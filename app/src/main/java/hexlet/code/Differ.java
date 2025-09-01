package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        if (format == null) {
            format = "stylish";
        }
        Path path1 = Path.of(filePath1);
        Path path2 = Path.of(filePath2);
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        String fileFormat1 = getFileFormat(path1);
        String fileFormat2 = getFileFormat(path2);
        if (!fileFormat1.equals(fileFormat2)) {
            throw new RuntimeException("Files has different format");
        }

        Map<String, Object> data1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> data2 = Parser.parse(content2, fileFormat2);

        List<Difference> differences = FindDifference.findDiff(data1, data2);

        return Formatter.format(differences, format);
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
