import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private ByteArrayOutputStream output;
    private Scanner userInput;

    public MockServerSocketManager(ByteArrayInputStream input, ByteArrayOutputStream output) {
        this.output = output;
        userInput = new Scanner(input);
    }

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }

    public String receiveInput() {
        return userInput.nextLine();
    }

    public void present(String message) {
        PrintWriter serverOutput = new PrintWriter(output, true);
        serverOutput.println(message);
    }
}
