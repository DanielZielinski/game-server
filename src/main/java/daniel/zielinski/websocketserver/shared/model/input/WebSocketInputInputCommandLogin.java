package daniel.zielinski.websocketserver.shared.model.input;

import lombok.Data;

@Data
public class WebSocketInputInputCommandLogin implements WebSocketInputCommand {
    private String actionName = WebSocketInputCommandType.LOGIN.name();

}