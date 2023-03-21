package daniel.zielinski.websocketserver.websocket.model.output;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OutputCommandPlayerSpawn {
    private String sessionId;
}

