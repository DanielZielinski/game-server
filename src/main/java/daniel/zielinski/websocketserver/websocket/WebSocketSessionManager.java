package daniel.zielinski.websocketserver.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebSocketSessionManager {

    private final List<WebSocketSessionWrapper> sessions = new ArrayList<>();

    public void addSession(WebSocketSession session) {
        sessions.add(new WebSocketSessionWrapper(session));
    }

    public void removeSession(WebSocketSession session) {
        sessions.removeIf(webSocketSessionWrapper ->
                webSocketSessionWrapper.getWebSocketSession().equals(session));
    }

    public List<WebSocketSessionWrapper> getAllSessions() {
        return sessions;
    }

    public WebSocketSessionWrapper getSession(WebSocketSession session) {
        return sessions.stream()
                .filter(webSocketSessionWrapper -> webSocketSessionWrapper.getWebSocketSession().equals(session))
                .findFirst()
                .orElseThrow();
    }

}

