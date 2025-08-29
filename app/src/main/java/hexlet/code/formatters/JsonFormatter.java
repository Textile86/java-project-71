package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.Difference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


public class JsonFormatter {
    public static String format(List<Difference> differences) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Map<String, Object>> result = new ArrayList<>();

            for (Difference diff : differences) {
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("key", diff.getKey());
                item.put("status", diff.getStatus());
                switch (diff.getStatus()) {
                    case "removed" -> item.put("value", diff.getOldValue());
                    case "added" -> item.put("value", diff.getNewValue());
                    case "unchanged" -> item.put("value", diff.getNewValue());
                    case "changed" -> {
                        item.put("oldValue", diff.getOldValue());
                        item.put("newValue", diff.getNewValue());
                    }
                    default -> throw new IllegalArgumentException("Unknown difference type !");
                }
                result.add(item);
            }

            return mapper.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException("Error generating JSON", e);
        }
    }
}

