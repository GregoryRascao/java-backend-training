package multithreading.examples2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example21BasicThreadPool {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
//        ExecutorService executor2 = Executors.newFixedThreadPool(2);
//        ExecutorService executor3 = Executors.newFixedThreadPool(2);


        executor.submit(() -> {
            //a very heavy job
            System.out.println("Task 1 running in " + Thread.currentThread().getName());
        });
        //Some threads stay idle
//        executor2.submit(
//            () -> System.out.println("I am a worker of executer 2!")
//        );
//
//        executor3.submit(
//            () -> System.out.println("I am a worker of executer 3!")
//        );

        executor.submit(() -> {
            System.out.println("Task 2 running in " + Thread.currentThread().getName());
        });

        executor.shutdown();
//        executor2.shutdown();
//        executor3.shutdown();
    }
}