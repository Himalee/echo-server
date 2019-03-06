import java.io.IOException;

public class EchoServer {
    private SocketManager serverSocketManager;

    public EchoServer(SocketManager serverSocketManager) {
        this.serverSocketManager = serverSocketManager;
    }

    public void start(int port) throws IOException {
        serverSocketManager.connect(port);
        String clientInput = serverSocketManager.receiveString();
        serverSocketManager.present(Message.confirmClientMessageReceived());
        serverSocketManager.present(clientInput);
    }
}
