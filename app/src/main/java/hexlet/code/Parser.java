package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, ObjectMapper mapper) throws IOException {
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
