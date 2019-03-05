public class MockServerSocketManager implements SocketManager {

    private boolean connectCalled = false;
    private String input;

    public MockServerSocketManager(String input) {
        this.input = input;
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
}
