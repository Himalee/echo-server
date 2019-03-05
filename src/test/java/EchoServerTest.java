import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class EchoServerTest {

    private int port = 1234;
    private String clientInput;
    private MockServerSocketManager mockServerSocketManager;

   @Before
   public void setUp() throws IOException {
       clientInput = "echo";
       mockServerSocketManager = new MockServerSocketManager(clientInput);
       EchoServer echoServer = new EchoServer(mockServerSocketManager);
       echoServer.start(port);
   }

    @Test
    public void startEchoServer_checkConnection() {
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startEchoServer_sendClientMessageToServer() {
        Assert.assertEquals(clientInput, mockServerSocketManager.receiveString());
    }
}
