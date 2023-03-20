package daniel.zielinski.websocketserver.command.domain;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketCommandType {

    LOGIN("login");
    private final String type;

    public static WebSocketCommandType fromType(String type) {
        for (WebSocketCommandType actionType : WebSocketCommandType.values()) {
            if (actionType.type.equals(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Type code not recognized: " + type);
    }
}