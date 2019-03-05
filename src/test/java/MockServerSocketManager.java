public class MockServerSocketManager implements SocketManager {
    private boolean connectCalled = false;

    public void connect(int port) {
        connectCalled = true;
    }

    public boolean wasConnectCalled() {
        return connectCalled;
    }
}
