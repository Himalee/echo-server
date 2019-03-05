import java.io.*;
import java.net.ServerSocket;

public class ServerSocketManager implements SocketManager {

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.accept();
    }
}
