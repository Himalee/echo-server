import java.io.*;
import java.util.Scanner;

public class CommandLineInterface {

    private InputStream input;
    private OutputStream output;

    public CommandLineInterface(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        Scanner serverInput = new Scanner(input);
        return serverInput.nextLine();
    }

    public void presentOutput(String message) {
        PrintWriter serverOutput = new PrintWriter(output, true);
        serverOutput.println(message);
    }
}
