package daniel.zielinski.websocketserver.message.infrastructure.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.zielinski.websocketserver.message.domain.WebsocketMessageReader;
import daniel.zielinski.websocketserver.shared.model.input.WebSocketInputCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

@Service
@RequiredArgsConstructor
class WebsocketMessageReaderImpl implements WebsocketMessageReader {

    private final ObjectMapper objectMapper;

    @Override
    public WebSocketInputCommand read(TextMessage message) {
        try {
            return objectMapper.readValue(message.getPayload(), WebSocketInputCommand.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
