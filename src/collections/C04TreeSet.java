package collections;

import java.util.TreeSet;

public class C04TreeSet {

    public static void main(String[] args) {
        TreeSet<String> fruits = new TreeSet<>();
        fruits.add("Apple");
        fruits.add("Pumpkin");
        fruits.add("Cherry");
        fruits.add("Banana");

        System.out.println("Original Set: " + fruits);

        fruits.remove("Banana");
        System.out.println("After Removal: " + fruits);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
