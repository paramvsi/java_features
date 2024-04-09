package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Collections class Array List in Java
public class C01ArrayList {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Original List: " + fruits);

        fruits.set(1, "Blueberry");
        System.out.println("After Update: " + fruits);

        fruits.remove(2);
        System.out.println("After Removal: " + fruits);

        Collections.sort(fruits);
        System.out.println("Sorted List: " + fruits);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        int size = fruits.size();
        System.out.println("length of list is: " + size);

        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("Array List converted to array is: "+ Arrays.toString(fruitsArray));

    }
}


