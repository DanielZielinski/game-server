package daniel.zielinski.websocketserver.message.domain;

import org.springframework.web.socket.WebSocketSession;

public interface WebsocketMessageSender {

    void send(WebSocketSession session, Object message);
}
