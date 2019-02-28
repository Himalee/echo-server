import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector {
    public Socket connect(ServerSocket serverSocket) throws IOException {
        return serverSocket.accept();
    }
}
