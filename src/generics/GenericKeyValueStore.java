package generics;

import java.util.HashMap;
import java.util.Map;

public class GenericKeyValueStore {
    private final Map<String, Object> store = new HashMap<>();

    public static void main(String[] args) {
        GenericKeyValueStore keyValueStore = new GenericKeyValueStore();

        // Storing different types of values
        keyValueStore.put("name", "John Doe");
        keyValueStore.put("age", 30);
        keyValueStore.put("salary", 50000.75);

        // Retrieving values
        String name = keyValueStore.get("name");
        int age = keyValueStore.get("age");
        double salary = keyValueStore.get("salary");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        // Using generics with bounded types
        keyValueStore.put("employee1", new Employee("Alice", 28));
        keyValueStore.put("employee2", new Employee("Bob", 32));

        Employee employee1 = keyValueStore.get("employee1");
        Employee employee2 = keyValueStore.get("employee2");

        System.out.println("Employee 1: " + employee1);
        System.out.println("Employee 2: " + employee2);
    }

    public <T> void put(String key, T value) {
        store.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) store.get(key);
    }
}

class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee {name='" + name + "', age=" + age + '}';
    }
}
