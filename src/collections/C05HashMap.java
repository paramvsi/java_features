package collections;

import java.util.HashMap;
import java.util.Map;

public class C05HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put(null, 15);
        ages.put("Charlie", 35);


        System.out.println("Original Map: " + ages);

        boolean hasAlice = ages.containsKey("Alice");
        System.out.println("Has key Alice? " + hasAlice);

        ages.remove("Bob");
        System.out.println("After Removal: " + ages);

        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
