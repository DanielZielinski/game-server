package daniel.zielinski.websocketserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.zielinski.websocketserver.message.domain.WebsocketMessageReader;
import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommand;
import daniel.zielinski.websocketserver.command_router.domain.WebSocketInputCommandRouter;
import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommandType;
import daniel.zielinski.websocketserver.session.infrstructure.service.WebSocketSessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
public class WebSocketMessageHandler extends TextWebSocketHandler {

    private final WebSocketSessionManager webSocketSessionManager;
    private final WebSocketInputCommandRouter webSocketInputCommandRouter;
    private final WebsocketMessageReader websocketMessageReader;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message){
        WebSocketInputCommand webSocketInputCommand = websocketMessageReader.read(message);
        webSocketInputCommandRouter.execute(webSocketInputCommand, session);
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        webSocketSessionManager.addSession(session);
        log.info("Client connected {}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        webSocketSessionManager.removeSession(session);
        log.info("Client disconnected {}", session.getId());
    }
}

