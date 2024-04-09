package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class C06LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> ages = new LinkedHashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        System.out.println("Original Map (insertion order): " + ages);

        ages.remove("Bob");
        System.out.println("After Removal: " + ages);

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
