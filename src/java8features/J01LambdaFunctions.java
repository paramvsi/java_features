package java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class J01LambdaFunctions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Steve", "John", "Anna", "Mike");

        // Sorting by length using a lambda expression
        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);
    }
}

