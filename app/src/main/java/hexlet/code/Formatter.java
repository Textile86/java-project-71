package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> data1, Map<String, Object> data2, String formatName) {
        switch (formatName) {
            case "stylish":
                return StylishFormatter.format(data1, data2);
            case "plain":
                return PlainFormatter.format(data1, data2);
            case "json":
                return JsonFormatter.format(data1, data2);
            default:
                throw new IllegalArgumentException("Unknown format");
        }
    }
}
