package projects.project1;

public class Monkey extends Animal {
    public Monkey(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Monkey make that sound: ouIn OuIn..");
    }

    @Override
    public void feed() {
        System.out.println("Feeding " + getName() + " with a banana");
    }
}