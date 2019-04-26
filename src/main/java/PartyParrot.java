import java.io.IOException;

public class PartyParrot {
    public static void main(String[] args) throws IOException {
        SocketManager serverSocketManager = new ServerSocketManager();
        EchoServer echoServer = new EchoServer(serverSocketManager);
        echoServer.start(8000);
    }
}
