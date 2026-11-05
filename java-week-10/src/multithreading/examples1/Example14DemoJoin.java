package multithreading.examples1;

public class Example14DemoJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker: " + i);
            }
        });

        t.start();
        t.join(); // wait for t
        System.out.println("Main continues after worker finishes.");
    }
}
