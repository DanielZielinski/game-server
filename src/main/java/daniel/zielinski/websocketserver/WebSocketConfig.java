package daniel.zielinski.websocketserver;


import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.zielinski.websocketserver.command_router.domain.WebSocketInputCommandRouter;
import daniel.zielinski.websocketserver.message.domain.WebsocketMessageReader;
import daniel.zielinski.websocketserver.session.infrstructure.service.WebSocketSessionManager;
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
    private final WebSocketInputCommandRouter webSocketInputCommandRouter;
    private final WebsocketMessageReader websocketMessageReader;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/ws")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new WebSocketMessageHandler(webSocketSessionManager, webSocketInputCommandRouter, websocketMessageReader);
    }

}

