package daniel.zielinski.websocketserver.player;

import org.springframework.web.socket.WebSocketSession;

public interface PlayerSpawn {
    void spawn(WebSocketSession webSocketSession);
}
