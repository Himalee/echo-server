import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {

    private int port = 1234;

    @Test
    public void startEchoServer_checkConnection() throws IOException {
        String clientInput = "echo";
        MockServerSocketManager mockServerSocketManager = new MockServerSocketManager(clientInput);
        EchoServer echoServer = new EchoServer(mockServerSocketManager);
        echoServer.start(port);
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startEchoServer_sendClientMessageToServer() throws IOException {
        String clientInput = "echo";
        MockServerSocketManager mockServerSocketManager = new MockServerSocketManager(clientInput);
        EchoServer echoServer = new EchoServer(mockServerSocketManager);
        echoServer.start(port);
        Assert.assertEquals(clientInput, mockServerSocketManager.receiveString());
    }
}
