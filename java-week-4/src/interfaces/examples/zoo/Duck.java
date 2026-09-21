package interfaces.examples.zoo;

public class Duck implements Flyable, Swimmable, MyRunnable {
    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void run() {
        System.out.println("running DUCK!");
    }
}
