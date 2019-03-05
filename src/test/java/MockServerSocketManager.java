import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private String input;
    ByteArrayOutputStream output;

    public MockServerSocketManager(String input, ByteArrayOutputStream output) {
        this.input = input;
        this.output = output;
    }

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public String receiveString() {
        return input;
    }

    public void present(String message) {
        PrintWriter serverOutput = new PrintWriter(output, true);
        serverOutput.println(message);
    }
}
