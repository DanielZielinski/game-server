package daniel.zielinski.websocketserver.player;

import daniel.zielinski.websocketserver.websocket.WebsocketMessageSender;
import daniel.zielinski.websocketserver.websocket.WebSocketSessionManager;
import daniel.zielinski.websocketserver.websocket.model.input.InputCommandPlayerMove;
import daniel.zielinski.websocketserver.websocket.model.output.OutputCommandPlayerMove;
import daniel.zielinski.websocketserver.websocket.model.output.WebSocketOutputCommandPlayerMove;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import static daniel.zielinski.websocketserver.websocket.model.output.WebSocketOutputCommandType.PLAYER_MOVE;

@Service
@Slf4j
@RequiredArgsConstructor
class PlayerMoveImpl implements PlayerMove {

    private final WebSocketSessionManager webSocketSessionManager;

    private final WebsocketMessageSender websocketMessageSender;

    @Override
    public void move(WebSocketSession webSocketSession, InputCommandPlayerMove playerMove) {
        webSocketSessionManager.getAllSessions().forEach(session -> {
            WebSocketOutputCommandPlayerMove outputPlayerMove = WebSocketOutputCommandPlayerMove.builder()
                    .actionName(PLAYER_MOVE.name())
                    .data(OutputCommandPlayerMove.builder()
                            .direction(playerMove.getDirection())
                            .sessionId(webSocketSession.getId())
                            .build())
                    .build();
            websocketMessageSender.send(session, outputPlayerMove);
        });
    }
}
