package daniel.zielinski.websocketserver.websocket.model.input;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketInputCommandType {

    PLAYER_LOGIN("player_login"),
    PLAYER_MOVE("player_move");
    private final String type;

    public static WebSocketInputCommandType fromType(String type) {
        for (WebSocketInputCommandType actionType : WebSocketInputCommandType.values()) {
            if (actionType.type.equals(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Type code not recognized: " + type);
    }
}