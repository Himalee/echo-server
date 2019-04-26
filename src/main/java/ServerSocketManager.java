import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager {

    private CommandLineInterface communicationChannel;

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        communicationChannel = cli(socket.getInputStream(), socket.getOutputStream());
    }

    public String receiveInput() {
         return communicationChannel.getInput();
    }

    public void present(String message) {
        communicationChannel.presentOutput(message);
    }

    private CommandLineInterface cli(InputStream input, OutputStream output) {
        return new CommandLineInterface(input, output);
    }
}
