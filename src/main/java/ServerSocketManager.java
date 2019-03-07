import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private Socket socket;
    private CommandLineInterface cli;

    public ServerSocketManager(CommandLineInterface cli) {
        this.cli = cli;
    }

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
    }

    public String receiveString() throws IOException {
         return cli.getInput(socket.getInputStream());
    }

    public void present(String message) throws IOException {
        cli.getOutput(socket.getOutputStream(), message);
    }
}
