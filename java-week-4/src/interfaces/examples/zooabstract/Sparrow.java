package interfaces.examples.zooabstract;

public class Sparrow extends FlyingAnimal {

    @Override
    void makeSound() {
        System.out.println("Sparrow chirping");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }

}
