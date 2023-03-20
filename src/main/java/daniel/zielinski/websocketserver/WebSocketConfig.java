package daniel.zielinski.websocketserver;


import daniel.zielinski.websocketserver.command.domain.WebSocketCommandExecutorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketSessionManager webSocketSessionManager;
    private final WebSocketCommandExecutorFactory webSocketCommandExecutorFactory;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(webSocketSessionManager, webSocketCommandExecutorFactory), "/ws")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    @Bean
    public WebSocketHandler webSocketHandler(WebSocketSessionManager webSocketSessionManager,
                                      WebSocketCommandExecutorFactory webSocketCommandExecutorFactory) {
        return new WebSocketMessageHandler(webSocketSessionManager, webSocketCommandExecutorFactory);
    }

}

