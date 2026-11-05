package multithreading.examples3;

import java.io.FileWriter;
import java.io.IOException;

public class DaemonThreads {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            try(FileWriter fw = new FileWriter("result.txt")) {
                fw.write("I ran");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Background thread finished!");
        });

        t.start();
        System.out.println("Main is finished!");
    }
}
