package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Th05Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit a Callable task to the executor and get a Future object
        Future<Integer> futureResult = executor.submit(() -> {
            // Simulate a long-running task
            Thread.sleep(2000);
            return 42; // Return the result of the computation
        });

        // Do some other tasks while the computation is in progress
        System.out.println("Other Tasks executing..");
        // Get the result of the computation, blocking if necessary
        Integer result = futureResult.get();

        System.out.println("Result: " + result);

        // Shutdown the executor
        executor.shutdown();
    }
}
