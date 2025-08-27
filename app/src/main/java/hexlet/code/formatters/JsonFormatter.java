package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.LinkedHashMap;


public class JsonFormatter {
    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Map<String, Object>> result = new ArrayList<>();

            TreeSet<String> allSortedKeys = new TreeSet<>();
            allSortedKeys.addAll(data1.keySet());
            allSortedKeys.addAll(data2.keySet());

            for (String key : allSortedKeys) {
                boolean hasKey1 = data1.containsKey(key);
                boolean hasKey2 = data2.containsKey(key);
                Object value1 = data1.get(key);
                Object value2 = data2.get(key);

                Map<String, Object> item = new LinkedHashMap<>();
                item.put("key", key);
                if (hasKey1 && hasKey2 && PlainFormatter.isEqual(value1, value2)) {
                    item.put("status", "unchanged");
                    item.put("value", value1);
                } else if (hasKey1 && !hasKey2) {
                    item.put("status", "removed");
                    item.put("value", value1);
                } else if (!hasKey1 && hasKey2) {
                    item.put("status", "added");
                    item.put("value", value2);
                } else if (hasKey1 && hasKey2 && !PlainFormatter.isEqual(value1, value2)) {
                    item.put("status", "changed");
                    item.put("oldValue", value1);
                    item.put("newValue", value2);
                }
                result.add(item);
            }
            return mapper.writeValueAsString(result);
        } catch (Exception e) {
            throw new RuntimeException("Error generating JSON", e);
        }

    }
}

