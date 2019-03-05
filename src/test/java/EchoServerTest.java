import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {

    private int port = 1234;

    @Test
    public void startEchoServer_checkConnection() throws IOException {
        MockServerSocketManager mockServerSocketManager = new MockServerSocketManager();
        EchoServer echoServer = new EchoServer(mockServerSocketManager);
        echoServer.start(port);
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

}
