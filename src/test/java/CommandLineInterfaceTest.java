import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandLineInterfaceTest {

    private CommandLineInterface cli;

    @Before
    public void setUp() {
        cli = new CommandLineInterface();
    }

    @Test
    public void getUserInput_fooBar() {
        Assert.assertEquals("FooBar", cli.getInput(new ByteArrayInputStream("FooBar".getBytes())));
    }

    @Test
    public void display_helloWorld() {
        String message = "Hello, World";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        cli.getOutput(new PrintStream(outContent), message);

        Assert.assertEquals("Hello, World\n", outContent.toString());
    }
}
