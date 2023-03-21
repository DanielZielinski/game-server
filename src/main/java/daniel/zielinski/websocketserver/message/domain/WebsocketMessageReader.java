package daniel.zielinski.websocketserver.message.domain;

import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommand;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public interface WebsocketMessageReader {
    WebSocketInputCommand read(TextMessage message);
}
