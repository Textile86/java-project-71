package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        if (format == null) {
            format = "stylish";
        }
        String content1 = Files.readString(Path.of(filePath1));
        String content2 = Files.readString(Path.of(filePath2));
        String fileFormat1 = getFileFormat(Path.of(filePath1));
        String fileFormat2 = getFileFormat(Path.of(filePath2));
        if (!fileFormat1.equals(fileFormat2)) {
            throw new RuntimeException("Files has different format");
        }
        Map<String, Object> data1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> data2 = Parser.parse(content2, fileFormat2);

        return Formatter.format(data1, data2, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String getFileFormat(Path filepath) {
        String filename = filepath.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            throw new IllegalArgumentException("File without extension: " + filename);
        }
        return filename.substring(lastDotIndex + 1);
    }

}
