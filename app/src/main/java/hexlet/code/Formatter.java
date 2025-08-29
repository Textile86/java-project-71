package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.List;

public class Formatter {
    public static String format(List<Difference> differences, String formatName) {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.format(differences);
            case "plain" -> PlainFormatter.format(differences);
            case "json" -> JsonFormatter.format(differences);
            default -> throw new RuntimeException("Unknown format: " + formatName);
        };
    }
}
