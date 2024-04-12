package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

record Person(String name, int age) {

    public static int compareByAge(Person a, Person b) {
        return Integer.compare(a.age, b.age);
    }

    public static Person createNew(String name, int age) {
        return new Person(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class J04MethodReference {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 24),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        );

        // Reference to a Static Method
        people.sort(Person::compareByAge);
        System.out.println("Sorted by age: " + people);

        // Reference to an Instance Method of a Particular Object
        Function<Person, String> getName = Person::name;
        List<String> names = people.stream().map(getName).toList();
        System.out.println("Names: " + names);

        // Reference to a Constructor
        List<Person> copiedPeople = people.stream()
                .map(p -> Person.createNew(p.name(), p.age()))
                .toList();
        System.out.println("Copied people: " + copiedPeople);
    }
}
