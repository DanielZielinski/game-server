package daniel.zielinski.websocketserver.websocket.model.output;

public interface WebSocketOutputCommand<T> {
    String getActionName();

    void setData(T data);
}

