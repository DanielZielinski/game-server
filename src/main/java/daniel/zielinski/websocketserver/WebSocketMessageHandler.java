package daniel.zielinski.websocketserver;

import daniel.zielinski.websocketserver.command.domain.WebSocketCommandExecutorFactory;
import daniel.zielinski.websocketserver.command.domain.WebSocketCommandType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
public class WebSocketMessageHandler extends TextWebSocketHandler {

    private final WebSocketSessionManager webSocketSessionManager;
    private final WebSocketCommandExecutorFactory webSocketCommandExecutorFactory;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String[] commandSplitted = message.getPayload().split("\\|");
        WebSocketCommandType webSocketCommandType = WebSocketCommandType.fromType(commandSplitted[0]);
        webSocketCommandExecutorFactory.execute(webSocketCommandType, commandSplitted, session);
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        webSocketSessionManager.addSession(session);
        log.info("Client connected {}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        webSocketSessionManager.removeSession(session);
        log.info("Client disconnected {}", session.getId());
    }
}

