package collections;

import java.util.LinkedList;

public class C02LinkedList {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.addFirst("Horse");
        animals.addLast("Elephant");

        System.out.println("Original List: " + animals);

        animals.set(1, "Tiger");
        System.out.println("After Update: " + animals);

        animals.removeFirst();
        animals.removeLast();
        System.out.println("After Removal: " + animals);

        for (String animal : animals) {
            System.out.println(animal);
        }
    }
}
