import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketManager implements SocketManager {

    private Socket socket;

    public void connect(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
    }

    public String receiveString() throws IOException {
        Scanner serverInput = new Scanner(socket.getInputStream());
        return serverInput.nextLine();
    }

    public void present(String message) throws IOException {
        PrintWriter serverOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        serverOutput.println(message);
    }
}
