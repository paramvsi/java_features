package generics;

public class GenericStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public GenericStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = (T) elements[--size];
        elements[size] = null; // Avoid memory leak
        return element;
    }

    public boolean isEmpty() {
        return size != 0;
    }

    private void resize() {
        int newSize = elements.length * 2;
        Object[] newElements = new Object[newSize];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while (stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }

        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);

        while (intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }
    }
}

