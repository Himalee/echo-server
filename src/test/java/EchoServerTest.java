import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;

public class EchoServerTest {

    private int port = 1234;
    private ByteArrayInputStream input;
    private MockServerSocketManager mockServerSocketManager;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private String clientInput;

   @Before
   public void setUp() throws IOException {
       clientInput = "echo\nhello\nworld\nq\n";
       input = new ByteArrayInputStream(clientInput.getBytes());
       mockServerSocketManager = new MockServerSocketManager(input, output);
       EchoServer echoServer = new EchoServer(mockServerSocketManager);
       echoServer.start(port);
   }

    @Test
    public void startEchoServer_checkConnection() {
        Assert.assertTrue(mockServerSocketManager.wasConnectCalled());
    }

    @Test
    public void startEchoServer_confirmClientMessageWasReceived() {
        Assert.assertThat(output.toString(), containsString("Message received"));
    }

    @Test
    public void startEchoServer_echoClientMessage() {
        Assert.assertThat(output.toString(), containsString("echo"));
    }

    @Test
    public void startEchoServer_clientAbleToSendMultipleMessages() {
        Assert.assertThat(output.toString(), containsString("Goodbye"));
    }
}
