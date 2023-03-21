package daniel.zielinski.websocketserver.websocket;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.socket.WebSocketSession;

@Data
@RequiredArgsConstructor
public class WebSocketSessionWrapper {
    private final WebSocketSession webSocketSession;
    private double lastPositionX = 235;
    private double lastPositionY = 235;

}
