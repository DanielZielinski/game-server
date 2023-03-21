package daniel.zielinski.websocketserver.websocket.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebSocketInputCommandPlayerMove implements WebSocketInputCommand<InputCommandPlayerMove> {
    private String actionName = WebSocketInputCommandType.PLAYER_MOVE.name();
    private InputCommandPlayerMove data;

}