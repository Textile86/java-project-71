package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class FindDifference {
    public static List<Difference> findDiff(Map<String, Object> data1, Map<String, Object> data2) {
        List<Difference> differences = new ArrayList<>();

        TreeSet<String> allSortedKeys = new TreeSet<>();
        allSortedKeys.addAll(data1.keySet());
        allSortedKeys.addAll(data2.keySet());

        for (String key : allSortedKeys) {
            boolean hasKey1 = data1.containsKey(key);
            boolean hasKey2 = data2.containsKey(key);
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (hasKey1 && hasKey2 && isEqual(value1, value2)) {
                differences.add(new Difference(key, "unchanged", value1, value2));
            } else if (hasKey1 && hasKey2 && !isEqual(value1, value2)) {
                differences.add(new Difference(key, "changed", value1, value2));
            } else if (hasKey1 && !hasKey2) {
                differences.add(new Difference(key, "removed", value1, null));
            } else if (!hasKey1 && hasKey2) {
                differences.add(new Difference(key, "added", null, value2));
            }

        }
        return differences;
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
