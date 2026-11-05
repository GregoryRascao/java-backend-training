package multithreading.examples3;

import java.util.concurrent.CompletableFuture;

public class Example33CombineFutures {

    public static void main(String[] args) {

        CompletableFuture<Integer> f1 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(3000);
                    System.out.println("Task 1 done");
                    return 10;
                });

        CompletableFuture<Integer> f2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(5500);
                    System.out.println("Task 2 done");
                    return 20;
                });

        CompletableFuture<Integer> combined =
                f1.thenCombine(f2, Integer::sum);

        combined.thenAccept(result -> {
                System.out.println("Final result: " + result);
            }
        );

        sleep(10000);
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}