package multithreading.examples1;

public class Example12DemoExtendsThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running in: " + getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
    }
}