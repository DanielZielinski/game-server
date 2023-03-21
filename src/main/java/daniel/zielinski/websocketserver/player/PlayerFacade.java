package daniel.zielinski.websocketserver.player;

import daniel.zielinski.websocketserver.websocket.model.input.InputCommandPlayerMove;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerFacade {

    private final PlayerMove playerMoveService;

    private final PlayerSpawn playerSpawn;

    public void movePlayer(WebSocketSession webSocketSession, InputCommandPlayerMove playerMove) {
        playerMoveService.move(webSocketSession, playerMove);
    }
    public void spawnPlayer(WebSocketSession webSocketSession) {
        playerSpawn.spawn(webSocketSession);
    }
}
