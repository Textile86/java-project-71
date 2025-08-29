package hexlet.code.formatters;

import hexlet.code.Difference;

import java.util.List;

public class StylishFormatter {
    public static String format(List<Difference> differences) {
        StringBuilder result = new StringBuilder("{\n");

        for (Difference diff : differences) {
            String key = diff.getKey();
            Object value1 = diff.getOldValue();
            Object value2 = diff.getNewValue();
            switch (diff.getStatus()) {
                case "removed" -> result.append("  - ").append(key).append(": ").append(value1).append("\n");
                case "added" -> result.append("  + ").append(key).append(": ").append(value2).append("\n");
                case "unchanged" -> result.append("    ").append(key).append(": ").append(value1).append("\n");
                case "changed" -> {
                    result.append("  - ").append(key).append(": ").append(value1).append("\n");
                    result.append("  + ").append(key).append(": ").append(value2).append("\n");
                }
                default -> throw new IllegalArgumentException("Unknown difference type !");
            }
        }
        result.append("}");

        return result.toString();
    }
}
