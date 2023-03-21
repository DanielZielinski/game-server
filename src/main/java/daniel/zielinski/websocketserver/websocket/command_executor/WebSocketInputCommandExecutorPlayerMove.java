package daniel.zielinski.websocketserver.websocket.command_executor;

import daniel.zielinski.websocketserver.player.PlayerFacade;
import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommandPlayerMove;
import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommandType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketInputCommandExecutorPlayerMove implements WebSocketInputCommandExecutor<WebSocketInputCommandPlayerMove> {

    private final PlayerFacade playerMoveFacade;
    @Override
    public void execute(WebSocketInputCommandPlayerMove webSocketInputCommandPlayerMove, WebSocketSession webSocketSession) {
        playerMoveFacade.movePlayer(webSocketSession, webSocketInputCommandPlayerMove.getData());
    }

    @Override
    public boolean find(String webSocketInputCommandType) {
        return webSocketInputCommandType.equals(WebSocketInputCommandType.PLAYER_MOVE.name());
    }
}
