package daniel.zielinski.websocketserver.shared.model.output;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OutputCommandSpawnPlayer {
    private String sessionId;
}

