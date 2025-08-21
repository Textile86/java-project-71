package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<String, Object> parse(Path filepath) throws IOException {
        String content = Files.readString(filepath);
        return MAPPER.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
