package daniel.zielinski.websocketserver.websocket.model.input;

import lombok.Data;

@Data
public class InputCommandPlayerLogin {

    private String username;
    private String password;
}
