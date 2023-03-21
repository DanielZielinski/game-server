package daniel.zielinski.websocketserver.websocket.command_executor;

import daniel.zielinski.websocketserver.authentication.AuthenticationFacade;
import daniel.zielinski.websocketserver.exception.ExceptionFacade;
import daniel.zielinski.websocketserver.player.PlayerFacade;
import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommandPlayerLogin;
import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommandType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketInputCommandExecutorPlayerLogin implements WebSocketInputCommandExecutor<WebSocketInputCommandPlayerLogin> {

    private final AuthenticationFacade authenticationFacade;

    private final PlayerFacade playerFacade;

    private final ExceptionFacade exceptionFacade;

    @Override
    public void execute(WebSocketInputCommandPlayerLogin webSocketCommandLogin, WebSocketSession webSocketSession) {

        if (authenticationFacade.authenticate()) {
            playerFacade.spawnPlayer(webSocketSession);
        } else {
            exceptionFacade.sendError(webSocketSession, "authentication failed");
        }
    }

    @Override
    public boolean find(String webSocketInputCommandType) {
        return webSocketInputCommandType.equals(WebSocketInputCommandType.PLAYER_LOGIN.name());
    }
}
