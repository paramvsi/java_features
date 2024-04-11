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

