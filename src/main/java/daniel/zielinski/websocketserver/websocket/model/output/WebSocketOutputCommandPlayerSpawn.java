package daniel.zielinski.websocketserver.websocket.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketOutputCommandPlayerSpawn implements WebSocketOutputCommand<OutputCommandPlayerSpawn> {
    private String actionName;
    private OutputCommandPlayerSpawn data;

}