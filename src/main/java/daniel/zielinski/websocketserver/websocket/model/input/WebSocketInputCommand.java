package daniel.zielinski.websocketserver.websocket.model.input;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "actionName",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WebSocketInputCommandPlayerLogin.class, name = "PLAYER_LOGIN"),
        @JsonSubTypes.Type(value = WebSocketInputCommandPlayerMove.class, name = "PLAYER_MOVE")
})
public interface WebSocketInputCommand<T> {
    String getActionName();
    T getData();
}

