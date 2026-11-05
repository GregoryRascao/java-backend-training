package multithreading.examples2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example23ThreadReuse {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.submit(() -> {
                System.out.println(
                        "Task " + taskId +
                                " executed by " + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}