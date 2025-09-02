package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        if (format == null) {
            format = "stylish";
        }
        Path path1 = Path.of(filePath1);
        Path path2 = Path.of(filePath2);
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        String dataFormat1 = getDataFormat(filePath1);
        String dataFormat2 = getDataFormat(filePath2);
        if (!dataFormat1.equals(dataFormat2)) {
            throw new RuntimeException("Files has different format");
        }

        Map<String, Object> data1 = Parser.parse(content1, dataFormat1);
        Map<String, Object> data2 = Parser.parse(content2, dataFormat2);

        List<Difference> differences = FindDifference.findDiff(data1, data2);

        return Formatter.format(differences, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String getDataFormat(String filepath) {
        String filename = Path.of(filepath).getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            throw new IllegalArgumentException("File without extension: " + filename);
        }
        String extension = filename.substring(lastDotIndex + 1);
        return switch (extension) {
            case "json" -> "json";
            case "yml", "yaml" -> "yaml";
            default -> throw new RuntimeException("Wrong data format: '" + extension + "'");
        };
    }
}
