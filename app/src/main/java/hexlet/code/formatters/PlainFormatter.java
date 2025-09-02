package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String format(List<Difference> differences) {
        StringBuilder result = new StringBuilder();

        for (Difference diff : differences) {
            String value1 = checkFormat(diff.getOldValue());
            String value2 = checkFormat(diff.getNewValue());
            switch (diff.getStatus()) {
                case "changed" -> {
                    result.append("Property '").append(diff.getKey()).append("' was updated. From ");
                    result.append(value1).append(" to ").append(value2).append("\n");
                }
                case "removed" ->
                    result.append("Property '").append(diff.getKey()).append("' was removed").append("\n");
                case "added" -> {
                    result.append("Property '").append(diff.getKey()).append("' was added with value: ");
                    result.append(value2).append("\n");
                }
                case "unchanged" -> result.append("");
                default -> throw new IllegalArgumentException("Unknown difference type ! '" + diff.getStatus() + "'");
            }
        }
        return result.toString().trim();
    }

    public static boolean isComplexValue(Object value) {
        return value instanceof Map || value instanceof List;
    }

    public static String checkFormat(Object value) {
        if (isComplexValue(value)) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }

}
