package collections;

import java.util.HashSet;

public class C03HashSet {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("Original Set: " + colors);

        boolean hasRed = colors.contains("Red");
        System.out.println("Set contains red? " + hasRed);

        colors.remove("Green");
        System.out.println("After Removal: " + colors);

        for (String color : colors) {
            System.out.println(color);
        }
    }
}
