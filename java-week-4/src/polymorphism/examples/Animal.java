package polymorphism.examples;

import java.util.List;


// Parent class
public class Animal {

    public static void main(String[] args)
    {
        List<Animal> animals = List.of(new Dog(), new Cat(), new Animal());

        for (Animal a : animals) {
            a.makeSound(); // same call, different result
        }
    }
    public void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

// Child class Dog
class Dog extends Animal
{
    @Override
    public void makeSound()
    {
        System.out.println("Woof!");
    }
}

class Cat extends Animal
{
    @Override
    public void makeSound()
    {
        System.out.println("Meow!");
    }
}