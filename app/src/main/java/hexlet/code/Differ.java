package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;


public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generateDiff(Parser.parse(Path.of(filePath1)), Parser.parse(Path.of(filePath2)));
    }

    public static String generateDiff(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder("{\n");

        TreeSet<String> allSortedKeys = new TreeSet<>();
        allSortedKeys.addAll(data1.keySet());
        allSortedKeys.addAll(data2.keySet());

        for (String key : allSortedKeys) {
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else if (data1.get(key).equals(data2.get(key))) {
                result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}

