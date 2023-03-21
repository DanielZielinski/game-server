package daniel.zielinski.websocketserver.shared.model.input;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "actionName",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WebSocketInputInputCommandLogin.class, name = "LOGIN")
})
public interface WebSocketInputCommand {
    String getActionName();
}

