package multithreading;

public class Th03Synchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        // Synchronized method to ensure atomic operation
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }


}
