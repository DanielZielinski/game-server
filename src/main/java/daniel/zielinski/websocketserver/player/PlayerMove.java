package daniel.zielinski.websocketserver.player;

import daniel.zielinski.websocketserver.websocket.model.input.InputCommandPlayerMove;
import org.springframework.web.socket.WebSocketSession;

public interface PlayerMove {
    void move(WebSocketSession webSocketSession, InputCommandPlayerMove playerMove);
}
