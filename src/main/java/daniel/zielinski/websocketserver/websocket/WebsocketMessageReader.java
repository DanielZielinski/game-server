package daniel.zielinski.websocketserver.websocket;

import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommand;
import org.springframework.web.socket.TextMessage;

public interface WebsocketMessageReader {
    WebSocketInputCommand read(TextMessage message);
}
