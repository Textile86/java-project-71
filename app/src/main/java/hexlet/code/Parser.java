package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String dataFormat) throws Exception {
        ObjectMapper mapper = getMapper(dataFormat);
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    private static ObjectMapper getMapper(String dataFormat) {
        return switch (dataFormat.toLowerCase()) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new RuntimeException("Wrong data format: '" + dataFormat + "'");
        };
    }
}
