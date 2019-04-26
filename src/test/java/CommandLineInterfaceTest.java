import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.io.*;

public class CommandLineInterfaceTest {

    private CommandLineInterface cli;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        InputStream input = new ByteArrayInputStream("FooBar".getBytes());
        outContent = new ByteArrayOutputStream();
        OutputStream output = new PrintStream(outContent);
        cli = new CommandLineInterface(input, output);
    }

    @Test
    public void getUserInput_fooBar() {
        Assert.assertEquals("FooBar", cli.getInput());
    }

    @Test
    public void display_helloWorld() {
        String message = "Hello, World";
        cli.presentOutput(message);

        Assert.assertEquals("Hello, World\n", outContent.toString());
    }
}
