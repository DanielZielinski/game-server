package daniel.zielinski.websocketserver.command.domain;

import org.springframework.web.socket.WebSocketSession;


public interface WebSocketCommandExecutor<T extends WebSocketCommand> {
    void execute(T command, WebSocketSession session);

    T parse(String[] commandSpllitted);

    WebSocketCommandType getType();
}

