package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Objects;

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

            if (hasKey1 && hasKey2 && Objects.equals(value1, value2)) {
                differences.add(new Difference(key, "unchanged", value1, value2));
            } else if (hasKey1 && hasKey2 && !Objects.equals(value1, value2)) {
                differences.add(new Difference(key, "changed", value1, value2));
            } else if (hasKey1 && !hasKey2) {
                differences.add(new Difference(key, "removed", value1, null));
            } else if (!hasKey1 && hasKey2) {
                differences.add(new Difference(key, "added", null, value2));
            }

        }
        return differences;
    }

}
