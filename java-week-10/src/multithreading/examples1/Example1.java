/**
 * Basic thread example.
 */

package multithreading.examples1;

public class Example1
{
    static Runnable task = () -> {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    };

    public static void main(String[] args) throws InterruptedException{
        Thread worker = new Thread(task, "Worker-1");
        worker.start();
        //worker.join();

        System.out.println("Main complete.");
    }
}
