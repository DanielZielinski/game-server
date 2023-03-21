package daniel.zielinski.websocketserver.shared.model.input;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketInputCommandType {

    LOGIN("login");
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