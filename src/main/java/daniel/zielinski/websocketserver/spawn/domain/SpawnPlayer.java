package daniel.zielinski.websocketserver.spawn.domain;

import org.springframework.web.socket.WebSocketSession;

public interface SpawnPlayer {
    void spawn(WebSocketSession webSocketSession);
}
