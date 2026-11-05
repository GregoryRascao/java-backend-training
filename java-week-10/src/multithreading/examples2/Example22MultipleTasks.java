package multithreading.examples2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example22MultipleTasks {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executor.submit(() -> {
                System.out.println("Task " + taskId + " started in " + Thread.currentThread().getName());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Task " + taskId + " finished");
            });
        }

        executor.shutdown();
    }
}