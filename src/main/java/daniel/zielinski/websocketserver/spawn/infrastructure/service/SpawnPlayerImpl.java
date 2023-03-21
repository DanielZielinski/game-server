package daniel.zielinski.websocketserver.spawn.infrastructure.service;

import daniel.zielinski.websocketserver.message.domain.WebsocketMessageSender;
import daniel.zielinski.websocketserver.session.infrstructure.service.WebSocketSessionManager;
import daniel.zielinski.websocketserver.shared.model.output.OutputCommandSpawnPlayer;
import daniel.zielinski.websocketserver.shared.model.output.WebSocketOutputInputCommandSpawnPlayer;
import daniel.zielinski.websocketserver.spawn.domain.SpawnPlayer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import static daniel.zielinski.websocketserver.shared.model.output.WebSocketOutputCommandType.SPAWN_PLAYER;

@Service
@Slf4j
@RequiredArgsConstructor
class SpawnPlayerImpl implements SpawnPlayer {

    private final WebSocketSessionManager webSocketSessionManager;

    private final WebsocketMessageSender websocketMessageSender;

    @Override
    public void spawn(WebSocketSession webSocketSession) {
        log.info("spawn new user in all existing clients");
        webSocketSessionManager.getAllSessions()
                .forEach(session -> {
                            WebSocketOutputInputCommandSpawnPlayer spawnPlayerMessage = WebSocketOutputInputCommandSpawnPlayer.builder()
                                    .data(OutputCommandSpawnPlayer.builder().sessionId(webSocketSession.getId()).build())
                                    .actionName(SPAWN_PLAYER.name())
                                    .build();
                            websocketMessageSender.send(session, spawnPlayerMessage);
                        }
                );

        log.info("spawn all existing users in new client");
        webSocketSessionManager.getAllSessions()
                .stream()
                .filter(session -> !session.equals(webSocketSession))
                .forEach(session -> {
                            WebSocketOutputInputCommandSpawnPlayer spawnPlayerMessage = WebSocketOutputInputCommandSpawnPlayer.builder()
                                    .data(OutputCommandSpawnPlayer.builder().sessionId(session.getId()).build())
                                    .actionName(SPAWN_PLAYER.name())
                                    .build();
                            websocketMessageSender.send(webSocketSession, spawnPlayerMessage);
                        }
                );
    }
}
