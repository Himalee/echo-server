import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStub extends ServerSocket {
    public ServerSocketStub() throws IOException {
    }

    public Socket accept() {
        return new Socket();
    }
}
