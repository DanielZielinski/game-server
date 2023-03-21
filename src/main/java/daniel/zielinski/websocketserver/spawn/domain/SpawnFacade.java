package daniel.zielinski.websocketserver.spawn.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpawnFacade {

    private final SpawnPlayer spawnPlayer;

    public void spawnPlayer(WebSocketSession webSocketSession) {
        spawnPlayer.spawn(webSocketSession);
    }
}
