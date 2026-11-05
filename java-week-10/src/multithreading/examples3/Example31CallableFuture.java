package multithreading.examples3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example31CallableFuture {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {
            System.out.println("Task started...");
            Thread.sleep(6000);
            return 42;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Waiting for result...");
        Integer result = future.get();

        System.out.println("Result: " + result);

        executor.shutdown();
    }
}