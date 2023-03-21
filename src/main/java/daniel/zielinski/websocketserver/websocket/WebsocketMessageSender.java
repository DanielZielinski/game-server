package daniel.zielinski.websocketserver.websocket;

import org.springframework.web.socket.WebSocketSession;

public interface WebsocketMessageSender {

    void send(WebSocketSession session, Object message);
}
