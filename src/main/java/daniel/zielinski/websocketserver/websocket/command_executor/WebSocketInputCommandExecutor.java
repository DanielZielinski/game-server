package daniel.zielinski.websocketserver.websocket.command_executor;

import daniel.zielinski.websocketserver.websocket.model.input.WebSocketInputCommand;
import org.springframework.web.socket.WebSocketSession;


public interface WebSocketInputCommandExecutor<T extends WebSocketInputCommand> {
    void execute(T command, WebSocketSession session);
    boolean find(String webSocketInputCommandType);
}

