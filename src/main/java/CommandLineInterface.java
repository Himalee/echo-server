import java.io.*;
import java.util.Scanner;

public class CommandLineInterface {

    public String getInput(InputStream input) {
        Scanner serverInput = new Scanner(input);
        return serverInput.nextLine();
    }

    public void getOutput(OutputStream output, String message) {
        PrintWriter serverOutput = new PrintWriter(new OutputStreamWriter(output), true);
        serverOutput.println(message);
    }
}
