package daniel.zielinski.websocketserver.command.infrastructure.service;

import daniel.zielinski.websocketserver.command.domain.WebSocketCommand;
import lombok.Data;

@Data
public class WebSocketCommandLogin implements WebSocketCommand {
    private String actionName;
}