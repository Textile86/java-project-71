package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PlainFormatter {
    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder();

        TreeSet<String> allSortedKeys = new TreeSet<>();
        allSortedKeys.addAll(data1.keySet());
        allSortedKeys.addAll(data2.keySet());

        for (String key : allSortedKeys) {
            String value1 = checkFormat(data1.get(key));
            String value2 = checkFormat(data2.get(key));
            if (data1.containsKey(key) && data2.containsKey(key) && !isEqual(data1.get(key), (data2.get(key)))) {
                result.append("Property '").append(key).append("' was updated. From ");
                result.append(value1).append(" to ").append(value2).append("\n");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("Property '").append(key).append("' was removed").append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("Property '").append(key).append("' was added with value: ");
                result.append(value2).append("\n");
            }
        }
        return result.toString().trim();
    }

    public static boolean isComplexValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return true;
        }
        return false;
    }

    public static String checkFormat(Object value) {
        if (isComplexValue(value)) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value.toString() + "'";
        }
        return value.toString();
    }

    public static boolean isEqual(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        } else if (value1 == null || value2 == null) {
            return false;
        }
        return value1.equals(value2);
    }

}
