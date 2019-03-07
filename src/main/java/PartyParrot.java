import java.io.IOException;

public class PartyParrot {
    public static void main(String[] args) throws IOException {
        CommandLineInterface cli = new CommandLineInterface();
        SocketManager serverSocketManager = new ServerSocketManager(cli);
        EchoServer echoServer = new EchoServer(serverSocketManager);
        echoServer.start(8000);
    }
}
