package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;

@CommandLine.Command(name = "gendiff", version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.", mixinStandardHelpOptions = true)
public class App implements Runnable {

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]") // |3|
    String format = "stylish";

    @Parameters(paramLabel = "filepath1", index = "0", description = "The file whose checksum to calculate.")
    File filepath1;
    @Parameters(paramLabel = "filepath2", index = "1", description = "The file whose checksum to calculate.")
    File filepath2;

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
