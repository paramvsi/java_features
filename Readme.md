# Java Features

All Java features to know for an intermediate developer

## Collections

- ArrayList - ArrayList is a part of the Java Collections Framework and is a resizable array implementation of the List interface. It provides a way to store a dynamically-sized collection of elements.
- LinkedList - LinkedList is a part of the Java Collections Framework and is a doubly-linked list implementation of the List and Deque interfaces. It provides a way to store a sequence of elements with efficient insertion and removal at both ends.
- HashSet - HashSet is a part of the Java Collections Framework and implements the Set interface. It is a collection that does not allow duplicate elements and has no guaranteed order of its elements.
- TreeSet - TreeSet is a part of the Java Collections Framework and implements the NavigableSet interface. It is a collection that stores elements in a sorted order and does not allow duplicate elements.
- HashMap - HashMap is a part of the Java Collections Framework and implements the Map interface. It stores key-value pairs and allows for fast retrieval based on the key. Allows null key and does not maintain insertion order.
- LinkedHashMap - LinkedHashMap is a part of the Java Collections Framework and extends HashMap. It maintains the insertion order of its elements, which means it stores key-value pairs in the order they were added.
- TreeMap - TreeMap is a part of the Java Collections Framework and implements the NavigableMap interface. It stores key-value pairs in a sorted order based on the natural ordering of its keys or a custom Comparator provided at the time of creation.


## Generics

A generic class is defined as the following

```
class ClassName<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
```

A method can also be generic, independent of whether the class is generic

```
public class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

```

You can restrict the types that can be used as type arguments in a parameterized type. For example, you can specify that a type parameter can only be a subclass of a particular class (or implement a particular interface):

```
class Box<T extends Number> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

```

Wildcards are used in generic code to specify that a parameter can accept a range of types rather than just one specific type. The most common wildcards are:

- ? extends T: Upper bounded wildcard. Accepts any type that is a subtype of T.
- ? super T: Lower bounded wildcard. Accepts any type that is a supertype of T.
- ?: Unbounded wildcard. Accepts any type.

## Multithreading

Multithreading is a core concept in Java that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such a program is called a thread, and each thread defines a separate path of execution. Java provides built-in support for multithreaded programming.

#### Thread Lifecycle
A thread in Java can be in one of the following states:

- New: The thread is created but not yet started.
- Runnable: The thread is ready to run and is waiting for CPU time.
- Running: The thread is executing.
- Blocked: The thread is blocked waiting for a monitor lock.
- Waiting: The thread is waiting indefinitely for another thread to perform a particular action.
- Timed Waiting: The thread is waiting for a specified period.
- Terminated: The thread has completed its execution.

#### Thread Methods
Some important methods in the Thread class are:

- start(): Starts the execution of the thread.
- run(): Defines the code to be executed by the thread.
- sleep(long millis): Causes the current thread to suspend execution for a specified period.
- join(): Waits for a thread to die.
- interrupt(): Interrupts the thread.
- yield(): Causes the currently executing thread object to temporarily pause and allow other threads to execute.


### Synchronization
Synchronization in Java is used to control the access of multiple threads to a shared resource. The synchronized keyword can be used to ensure that only one thread at a time can execute a method or block of code.

```
synchronized void method() {
    // code to be synchronized
}
```
### Future
The Future interface represents the result of an asynchronous computation. It provides methods to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation. The result can only be retrieved using the get method when the computation has completed, blocking if necessary until it is ready.

### CompletableFuture
CompletableFuture is an extension of the Future interface that provides a lot of flexibility and allows for more complex asynchronous operations. It can be manually completed and used to build complex asynchronous pipelines. CompletableFuture also provides a lot of methods for composing, combining, and handling asynchronous computation steps.

## Java 8 Features

- Lambda Expressions: One of the most significant additions, lambda expressions simplify the writing of implementations for interfaces that have a single abstract method (functional interfaces). They provide a clear and concise way to represent one method interface using an expression.

- Stream API: Java 8 introduced the Stream API, which allows for declarative processing of collections of objects. This API supports sequence operations like filter, map, reduce, find, match, sort, etc. Streams can be parallel or sequential.

- Optional: Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.

- Default and Static Methods in Interfaces: Java 8 allows interfaces to have default and static methods. A default method includes an implementation and can be included in any interface, providing backward compatibility for old interfaces. Static methods in interfaces help in providing utility methods.

- Date and Time API: An improved, immutable Joda-Time-inspired Date and Time API. This new API is found under the java.time package and provides functionalities for date, time, duration, and periods.

- Method References: Method references help to point to methods by their names. A method reference is described using "::" symbol. They serve as shorthand for lambda expressions calling a single method.

## Design Patterns in Java

Design patterns are essential tools for software developers to solve common design problems in a reusable and efficient way. In Java, you can implement various design patterns to improve the structure, flexibility, and maintainability of your code. Here's an overview of some commonly used design patterns in Java:

### Creational Patterns
Creational patterns are all about class instantiation or object creation. They help make a system independent of how its objects are created, composed, and represented.

#### Singleton 
The Singleton pattern ensures that a class has only one instance, and provides a global point of access to it. This is particularly useful when exactly one object is needed to coordinate actions across the system.

```

public class Singleton {
    private static Singleton instance;

    private Singleton() {}  // Private constructor to prevent instantiation

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

#### Factory Method Pattern
This pattern defines an interface for creating an object but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses

```

abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    // Factory method
    public abstract Button createButton();
}

class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Render a button in a Windows style.");
    }
}

```

#### Abstract Factory Pattern
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

```

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

```

#### Builder Pattern
The Builder pattern constructs a complex object step by step. This pattern allows you to produce different types and representations of an object using the same construction process.

```

class Car {
    private String wheels;
    private String engine;
    private String seats;

    // Getters and setters for each field
}

class CarBuilder {
    private Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder setWheels(String wheels) {
        car.setWheels(wheels);
        return this;
    }

    public CarBuilder setEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    public CarBuilder setSeats(String seats) {
        car.setSeats(seats);
        return this;
    }

    public Car build() {
        return car;
    }
}

```

#### Prototype Pattern
The Prototype pattern is used when the types of objects to create are determined by a prototypical instance, which is cloned to produce new objects. This pattern is used to avoid subclasses of an object creator in the client application, like the abstract factory pattern does

```

interface Prototype {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }
}

```

### Structural Design Patterns
Structural design patterns are all about organizing different classes and objects to form larger structures and provide new functionality. Here is an overview of some commonly used structural patterns in Java:

#### Adapter Pattern
The Adapter pattern allows objects with incompatible interfaces to work together by wrapping its own interface around that of an already existing class.

```

// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee class
class AdvancedMediaPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMP4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVLC(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMP4(fileName);
        }
    }
}

// Using the adapter
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

```

#### Decorator Pattern
The Decorator pattern allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.

```

interface Coffee {
    double cost();
    String ingredients();
}

class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 1;
    }

    @Override
    public String ingredients() {
        return "Coffee";
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }

    @Override
    public String ingredients() {
        return coffee.ingredients() + ", Milk";
    }
}

class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.2;
    }

    @Override
    public String ingredients() {
        return coffee.ingredients() + ", Sugar";
    }
}

```

#### Facade Pattern
The Facade pattern provides a simplified interface to a complex subsystem.

```

class Computer {
    public void getElectricShock() { System.out.println("Ouch!"); }
    public void makeSound() { System.out.println("Beep beep!"); }
    public void showLoadingScreen() { System.out.println("Loading.."); }
    public void bam() { System.out.println("Ready to be used!"); }
}

class ComputerFacade {
    private Computer computer;

    public ComputerFacade(Computer computer) {
        this.computer = computer;
    }

    public void turnOn() {
        computer.getElectricShock();
        computer.makeSound();
        computer.showLoadingScreen();
        computer.bam();
    }

    public void turnOff() {
        computer.getElectricShock();
        computer.makeSound();
    }
}

```

#### Proxy Pattern
The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

```

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

```

### Behavioral Patterns
Behavioral design patterns are all about improving communication between disparate objects in a system. They help in defining complex flow of control, which makes the system more flexible and efficient. Here are descriptions and Java code examples for several commonly used behavioral patterns:

#### Observer Pattern
This pattern allows a subject to notify all its observers about changes without knowing who these observers are. It's particularly useful for creating a publish-subscribe model.

```

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

```

#### Strategy Pattern
This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

```

interface Strategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

```

#### Command Pattern
This pattern turns a request into a stand-alone object that contains all information about the request. This transformation allows you to parameterize methods with different requests, delay or queue a request's execution, and support undoable operations

```

interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

```

#### Template Method Pattern
This pattern defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

```

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

```

#### Iterator Pattern
This pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

```

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

```