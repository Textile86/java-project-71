package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(
    name = "gendiff", mixinStandardHelpOptions = true,
    version = "gendiff 1.0",
    description = "Compares two configuration files and shows a difference."
)

public final class App implements Callable<Integer> {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Parameters(
        paramLabel = "filepath1",
        description = "path to first file"
    )
    private String filepath1;

    @Parameters(
        paramLabel = "filepath2",
        description = "path to second file"
    )
    private String filepath2;

    @Option(
        names = {"-f", "--format"},
        description = "output format [default: ${DEFAULT-VALUE}]",
        defaultValue = "stylish"
    )

    private String format = "stylish";

    @Override
    public Integer call() throws IOException {
        String diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }
}
