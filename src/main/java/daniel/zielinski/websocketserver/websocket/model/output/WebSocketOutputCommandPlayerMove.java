package daniel.zielinski.websocketserver.websocket.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketOutputCommandPlayerMove implements WebSocketOutputCommand<OutputCommandPlayerMove> {
    private String actionName;
    private OutputCommandPlayerMove data;

}