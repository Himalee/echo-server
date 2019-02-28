import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ServerConnectorTest {
    @Test
    public void clientLookingToConnectToServer_establishClientServerConnection() throws IOException {
        ServerSocket serverSocketStub = new ServerSocketStub();
        ServerConnector serverConnector = new ServerConnector();
        Assert.assertThat(serverConnector.connect(serverSocketStub), instanceOf(Socket.class));
    }
}
