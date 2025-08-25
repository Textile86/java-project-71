package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path filepath) throws IOException {
        ObjectMapper mapper = getMapper(getFormat(filepath));
        String content = Files.readString(filepath);
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }

    private static ObjectMapper getMapper(String format) {
        switch (format.toLowerCase()) {
            case "json":
                return new ObjectMapper();
            case "yml", "yaml":
                return new YAMLMapper();
            default:
                throw new IllegalArgumentException("Wrong format: " + format);
        }
    }

    public static String getFormat(Path filepath) {
        String filename = filepath.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            throw new IllegalArgumentException("File without extension: " + filename);
        }
        return filename.substring(lastDotIndex + 1);
    }
}
