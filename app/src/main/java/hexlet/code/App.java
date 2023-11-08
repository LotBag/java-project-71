package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "gendiff", version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.", mixinStandardHelpOptions = true)
public class App implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
