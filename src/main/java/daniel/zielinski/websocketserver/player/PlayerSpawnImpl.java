package daniel.zielinski.websocketserver.player;

import daniel.zielinski.websocketserver.websocket.WebsocketMessageSender;
import daniel.zielinski.websocketserver.websocket.WebSocketSessionManager;
import daniel.zielinski.websocketserver.websocket.model.output.OutputCommandPlayerSpawn;
import daniel.zielinski.websocketserver.websocket.model.output.WebSocketOutputCommandPlayerSpawn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import static daniel.zielinski.websocketserver.websocket.model.output.WebSocketOutputCommandType.PLAYER_SPAWN;

@Service
@Slf4j
@RequiredArgsConstructor
class PlayerSpawnImpl implements PlayerSpawn {

    private final WebSocketSessionManager webSocketSessionManager;

    private final WebsocketMessageSender websocketMessageSender;

    @Override
    public void spawn(WebSocketSession webSocketSession) {
        log.info("spawn new user in all existing clients");
        webSocketSessionManager.getAllSessions()
                .forEach(session -> {
                            WebSocketOutputCommandPlayerSpawn spawnPlayerMessage = WebSocketOutputCommandPlayerSpawn.builder()
                                    .data(OutputCommandPlayerSpawn.builder().sessionId(webSocketSession.getId()).build())
                                    .actionName(PLAYER_SPAWN.name())
                                    .build();
                            websocketMessageSender.send(session, spawnPlayerMessage);
                        }
                );

        log.info("spawn all existing users in new client");
        webSocketSessionManager.getAllSessions()
                .stream()
                .filter(session -> !session.equals(webSocketSession))
                .forEach(session -> {
                            WebSocketOutputCommandPlayerSpawn spawnPlayerMessage = WebSocketOutputCommandPlayerSpawn.builder()
                                    .data(OutputCommandPlayerSpawn.builder().sessionId(session.getId()).build())
                                    .actionName(PLAYER_SPAWN.name())
                                    .build();
                            websocketMessageSender.send(webSocketSession, spawnPlayerMessage);
                        }
                );
    }
}
