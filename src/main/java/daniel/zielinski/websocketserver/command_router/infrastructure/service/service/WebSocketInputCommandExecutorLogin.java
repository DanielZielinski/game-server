package daniel.zielinski.websocketserver.command_router.infrastructure.service.service;

import daniel.zielinski.websocketserver.authentication.domain.AuthenticationFacade;
import daniel.zielinski.websocketserver.command_router.domain.WebSocketInputCommandExecutor;
import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputInputCommandLogin;
import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommandType;
import daniel.zielinski.websocketserver.exception.domain.ExceptionFacade;
import daniel.zielinski.websocketserver.spawn.domain.SpawnFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketInputCommandExecutorLogin implements WebSocketInputCommandExecutor<WebSocketInputInputCommandLogin> {

    private final AuthenticationFacade authenticationFacade;

    private final SpawnFacade spawnFacade;

    private final ExceptionFacade exceptionFacade;

    @Override
    public void execute(WebSocketInputInputCommandLogin webSocketCommandLogin, WebSocketSession webSocketSession) {

        if (authenticationFacade.authenticate()) {
            spawnFacade.spawnPlayer(webSocketSession);
        } else {
            exceptionFacade.sendError(webSocketSession, "authentication failed");
        }
    }

    @Override
    public boolean find(String webSocketInputCommandType) {
        return webSocketInputCommandType.equals(WebSocketInputCommandType.LOGIN.name());
    }
}
