package daniel.zielinski.websocketserver.command_router.domain;

import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketInputCommandRouter {
    private final List<WebSocketInputCommandExecutor> webSocketInputCommandExecutors;
    public void execute(WebSocketInputCommand webSocketInputCommand, WebSocketSession session) {
        webSocketInputCommandExecutors.stream()
                .filter(webSocketInputCommandExecutor -> webSocketInputCommandExecutor.find(webSocketInputCommand.getActionName()))
                .findFirst()
                .ifPresentOrElse(
                        webSocketInputCommandExecutor -> webSocketInputCommandExecutor.execute(webSocketInputCommand, session),
                        () -> {
                            throw new IllegalArgumentException();
                        });
    }

}
