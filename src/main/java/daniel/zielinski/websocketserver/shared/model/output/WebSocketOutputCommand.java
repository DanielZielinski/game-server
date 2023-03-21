package daniel.zielinski.websocketserver.shared.model.output;

public interface WebSocketOutputCommand<T> {
    String getActionName();

    void setData(T data);
}

