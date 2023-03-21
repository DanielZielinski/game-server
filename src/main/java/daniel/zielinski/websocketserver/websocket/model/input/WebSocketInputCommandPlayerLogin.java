package daniel.zielinski.websocketserver.websocket.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebSocketInputCommandPlayerLogin implements WebSocketInputCommand<InputCommandPlayerLogin> {
    private String actionName = WebSocketInputCommandType.PLAYER_LOGIN.name();

    private InputCommandPlayerLogin data;
}