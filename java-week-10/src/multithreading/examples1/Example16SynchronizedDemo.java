package multithreading.examples1;

public class Example16SynchronizedDemo {
    static int counter = 0;

    //only one thread can enter.
    //kitchen is so small, only for 1
    static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter = " + counter); // now reliably 200000
    }
}