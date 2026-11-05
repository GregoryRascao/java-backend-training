package multithreading.examples3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class Example32CompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try(FileWriter fw = new FileWriter("result.txt")) {
                        fw.write("I ran");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return 10;

                }).thenApply(x -> x * 2);

        System.out.println("Main starts...");

        future.thenAccept(result ->
                System.out.println("Result: " + result)
        );
//
//        // wait a bit so program doesn't exit immediately
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("main finishes");
    }
}