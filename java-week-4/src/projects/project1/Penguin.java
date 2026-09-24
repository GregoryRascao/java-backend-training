package projects.project1;

public class Penguin extends Animal {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " do: unknown..");
    }

    @Override
    public void feed() {
        System.out.println("Feeding " + getName() + " with a fish");
    }
}