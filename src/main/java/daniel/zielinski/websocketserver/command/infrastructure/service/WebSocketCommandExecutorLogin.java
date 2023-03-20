package daniel.zielinski.websocketserver.command.infrastructure.service;

import daniel.zielinski.websocketserver.WebSocketSessionManager;
import daniel.zielinski.websocketserver.command.domain.WebSocketCommandExecutor;
import daniel.zielinski.websocketserver.command.domain.WebSocketCommandType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketCommandExecutorLogin implements WebSocketCommandExecutor<WebSocketCommandLogin> {

    private final WebSocketSessionManager webSocketSessionManager;

    @Override
    public void execute(WebSocketCommandLogin webSocketCommandLogin, WebSocketSession webSocketSession) {
        log.info("login new user in all existing clients");
        webSocketSessionManager.getAllSessions()
                .forEach(session -> {
                            String message = "login".concat("|").concat(webSocketSession.getId());
                            log.info("send {} into {}", message, session.getId());
                            try {
                                session.sendMessage(new TextMessage(message));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

        log.info("login all existing users in new client");
        webSocketSessionManager.getAllSessions()
                .stream()
                .filter(session -> !session.equals(webSocketSession))
                .forEach(session -> {
                            String message = "login".concat("|").concat(session.getId());
                            log.info("send {} into {}", message, webSocketSession.getId());
                            try {
                                webSocketSession.sendMessage(new TextMessage(message));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

    }

    @Override
    public WebSocketCommandLogin parse(String[] commandSpllitted) {
        WebSocketCommandLogin webSocketCommandLogin = new WebSocketCommandLogin();
        webSocketCommandLogin.setActionName(commandSpllitted[0]);
        return webSocketCommandLogin;
    }

    @Override
    public WebSocketCommandType getType() {
        return WebSocketCommandType.LOGIN;
    }
}
