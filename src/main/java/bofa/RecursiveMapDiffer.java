package bofa;

import java.util.HashMap;
import java.util.Map;

public class RecursiveMapDiffer {

    static StringBuilder sb = new StringBuilder();
    static Boolean matches = true;
    public static void diffMaps(Map<?, ?> map1, Map<?, ?> map2, String path) {

        for (Object key : map1.keySet()) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (value2 == null) {
                String remark = "Key '" + key + "' not found in map2 at path: " + path + "\n";
                sb.append(remark);
                matches = false;
                continue;
            }

            if (value1 instanceof Map && value2 instanceof Map) {
                // Recursive call for nested maps
                diffMaps((Map<?, ?>) value1, (Map<?, ?>) value2, path + "/" + key);
            } else {
                if (!value1.equals(value2)) {
                    String diff =("Difference found for key '" + key + "' at path: " + path + "\n"
                    + "Value in map1: " + value1 + "\n"
                    + "Value in map2: " + value2 + "\n");
                    sb.append(diff);
                    matches = false;
                }
            }
        }

        // Check for keys in map2 that are not present in map1
        for (Object key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                String remark = "Key '" + key + "' not found in map1 at path: " + path + "\n";
                sb.append(remark);
                matches = false;
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Create two sample HashMaps for comparison
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", new HashMap<String, Object>() {{
            put("nestedKey1", "nestedValue1");
            put("nestedKey2", "nestedValue2");
        }});

        Map<String, Object> map2 = new HashMap<>();
        map2.put("key1", "value1");
        map2.put("key2", new HashMap<String, Object>() {{
            put("nestedKey1", "nestedValue1");
            put("nestedKey2", "differentValue"); // Difference here
        }});

        // Compare the HashMaps recursively
        diffMaps(map1, map2, "");
        Map<String, Object> diffResult = new HashMap<>();
        diffResult.put("matches", matches);
        diffResult.put("diffs", sb.toString());
        System.out.println(sb);
    }
}
