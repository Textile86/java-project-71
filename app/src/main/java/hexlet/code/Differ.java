package hexlet.code;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;


public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        if (format == null) {
            format = "stylish";
        }
        String format1 = Parser.getFileFormat(Path.of(filePath1));
        String format2 = Parser.getFileFormat(Path.of(filePath2));
        if (!format1.equals(format2)) {
            throw new IllegalArgumentException("Files has different format");
        }
        Map<String, Object> data1 = Parser.parse(Path.of(filePath1));
        Map<String, Object> data2 = Parser.parse(Path.of(filePath2));

        return Formatter.format(data1, data2, format);
    }

}
