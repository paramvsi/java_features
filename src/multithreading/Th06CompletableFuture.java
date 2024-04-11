package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Th06CompletableFuture {
    public static void main(String[] args) {
        // Create a CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // Run a task asynchronously and complete the CompletableFuture
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(2000); // Simulate a long-running task
            completableFuture.complete("Hello, World!"); // Complete the CompletableFuture
            return null;
        });

        // Do some other tasks while the computation is in progress

        // Get the result of the computation, blocking if necessary
        completableFuture.thenAccept(result -> System.out.println("Result: " + result));

        // Wait for the CompletableFuture to be completed (for demonstration purposes)
        completableFuture.join();
    }
}
