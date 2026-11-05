package multithreading.examples1;

public class Example15RaceConditionDemo {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter++;
            // Separating numbers with _ is allowed and it increases readability.
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter++;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter = " + counter); // expected 200000, might be less
    }
}
