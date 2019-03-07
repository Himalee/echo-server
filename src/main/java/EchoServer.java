import java.io.IOException;

public class EchoServer {
    private SocketManager serverSocketManager;
    private String COMMAND_TO_QUIT = "q";

    public EchoServer(SocketManager serverSocketManager) {
        this.serverSocketManager = serverSocketManager;
    }

    public void start(int port) throws IOException {
        serverSocketManager.connect(port);
        serverSocketManager.present(Message.menu());
        acceptAndShowMessageUntilServerShutsDown();
    }

    public void acceptAndShowMessageUntilServerShutsDown() throws IOException {
        String clientInput = serverSocketManager.receiveString();
        while(!clientInput.equals(COMMAND_TO_QUIT)) {
            serverSocketManager.present(Message.confirmClientMessageReceived());
            serverSocketManager.present(clientInput);
            clientInput = serverSocketManager.receiveString();
        }
        serverSocketManager.present(Message.serverShutsDown());
    }
}


