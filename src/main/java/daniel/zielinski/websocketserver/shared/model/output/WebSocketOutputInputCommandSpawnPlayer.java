package daniel.zielinski.websocketserver.shared.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketOutputInputCommandSpawnPlayer implements WebSocketOutputCommand<OutputCommandSpawnPlayer> {
    private String actionName;
    private OutputCommandSpawnPlayer data;

}