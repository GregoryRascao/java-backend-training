package multithreading.examples1;

public class Example11DemoRunnable {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello from: " + Thread.currentThread().getName());
        };

        Thread t = new Thread(task);
        t.start(); // IMPORTANT: start() runs in a new thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}