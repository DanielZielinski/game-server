package daniel.zielinski.websocketserver.command_router.domain;

import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommand;
import org.springframework.web.socket.WebSocketSession;


public interface WebSocketInputCommandExecutor<T extends WebSocketInputCommand> {
    void execute(T command, WebSocketSession session);
    boolean find(String webSocketInputCommandType);
}

