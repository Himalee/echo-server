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
        acceptAndEchoMessageUntilServerShutsDown();
    }

    private void acceptAndEchoMessageUntilServerShutsDown() throws IOException {
        String clientInput = serverSocketManager.receiveInput();
        while(!clientInput.equals(COMMAND_TO_QUIT)) {
            serverSocketManager.present(Message.confirmClientMessageReceived());
            serverSocketManager.present(clientInput);
            clientInput = serverSocketManager.receiveInput();
        }
        serverSocketManager.present(Message.serverShutsDown());
    }
}


