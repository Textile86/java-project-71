package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class StylishFormatter {
    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder("{\n");

        TreeSet<String> allSortedKeys = new TreeSet<>();
        allSortedKeys.addAll(data1.keySet());
        allSortedKeys.addAll(data2.keySet());

        for (String key : allSortedKeys) {
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else if (data1.get(key) != null && data1.get(key).equals(data2.get(key))) {
                result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (data1.get(key) == null && data2.get(key) == null) {
                result.append("    ").append(key).append(": null\n");
            } else {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
