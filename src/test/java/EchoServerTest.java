import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class EchoServerTest {

    private int port = 1234;
    private String clientInput;
    private MockServerSocketManager mockServerSocketManager;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

   @Before
   public void setUp() throws IOException {
       clientInput = "echo";
       mockServerSocketManager = new MockServerSocketManager(clientInput, output);
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

    @Test
    public void startEchoServer_confirmClientMessageWasReceived() {
        Assert.assertThat(output.toString(), containsString("Message received"));
    }
}
