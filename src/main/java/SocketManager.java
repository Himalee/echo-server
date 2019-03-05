import java.io.IOException;

public interface SocketManager {
    void connect(int port) throws IOException;
    String receiveString() throws IOException;
}
