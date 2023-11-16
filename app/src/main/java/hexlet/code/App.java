package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@CommandLine.Command(name = "gendiff", version = "gendiff very early access",
        description = "Compares two configuration files and shows a difference.", mixinStandardHelpOptions = true)
public class App implements Callable<String> {

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    String format = "stylish";

    @Parameters(paramLabel = "filepath1", index = "0", description = "Path to first file.")
    static String filepath1;
    @Parameters(paramLabel = "filepath2", index = "1", description = "Path to second file.")
    static String filepath2;

    @Override
    public String call() throws Exception {
        return Differ.generate(filepath1, filepath2);
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
