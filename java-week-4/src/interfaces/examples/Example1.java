package interfaces.examples;

/**
 * Example 1: Implementing Multiple Interfaces
 *
 * This example demonstrates how a class can implement multiple interfaces,
 * allowing it to inherit behaviors from different sources.
 *
 * In this example, we have two interfaces: Drivable and Honkable.
 * The Car class implements both interfaces, providing concrete implementations
 * for the drive and honk methods.
 */

public class Example1 {
    public static void main(String[] args)
    {
        Car car = new Car();
        car.drive();
        car.honk();
    }
}

// Ability 1
interface Drivable {
    void drive(); // Methods are by default public and abstract
}

// Ability 2
interface Honkable {
    void honk();
}

// Class implements multiple interfaces
class Car implements Drivable, Honkable {
    @Override
    public void drive()
    {
        System.out.println("Car is driving...");
    }

    @Override
    public void honk()
    {
        System.out.println("Car says: Beep Beep!");
    }
}

/*
    Inheritance is about identity.
    Interfaces are about capability.
 */

