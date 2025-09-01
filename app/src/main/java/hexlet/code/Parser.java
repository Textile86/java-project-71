package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String fileFormat) throws IOException {
        ObjectMapper mapper = getMapper(fileFormat);
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    private static ObjectMapper getMapper(String fileFormat) {
        return switch (fileFormat.toLowerCase()) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new RuntimeException("Wrong format: " + fileFormat);
        };
    }
}
