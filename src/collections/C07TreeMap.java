package collections;

import java.util.Map;
import java.util.TreeMap;

public class C07TreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> ages = new TreeMap<>();
        ages.put("Charlie", 35);
        ages.put("Alice", 30);
        ages.put("Bob", 25);

        System.out.println("Original Map (sorted order): " + ages);

        ages.remove("Bob");
        System.out.println("After Removal: " + ages);

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
