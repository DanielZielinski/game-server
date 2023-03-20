package daniel.zielinski.websocketserver.command.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketCommandExecutorFactory<T extends WebSocketCommand> {
    private final List<WebSocketCommandExecutor<T>> webSocketCommandExecutors;
    public void execute(WebSocketCommandType webSocketCommandType, String[] commandSplitted, WebSocketSession session) {
        webSocketCommandExecutors.stream()
                .filter(webSocketCommandExecutor -> webSocketCommandExecutor.getType() == webSocketCommandType)
                .findFirst()
                .ifPresentOrElse(
                        webSocketCommandExecutor -> webSocketCommandExecutor.execute(webSocketCommandExecutor.parse(commandSplitted), session),
                        () -> {
                            throw new IllegalArgumentException();
                        });
    }

}
