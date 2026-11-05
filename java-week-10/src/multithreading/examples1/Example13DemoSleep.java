package multithreading.examples1;

public class Example13DemoSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(500); // 0.5 seconds
        System.out.println("End");
    }
}