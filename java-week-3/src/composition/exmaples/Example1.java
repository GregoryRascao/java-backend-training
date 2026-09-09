package composition.exmaples;

/**
 * Example of Composition in Java
 * A Car HAS-A Engine
 */

public class Example1
{
    public static void main(String[] args)
    {
        Car car = new Car();
        car.drive();
    }
}


// Engine.java
class Engine
{
    public void start()
    {
        System.out.println("Engine started...");
    }
}

// Car.java
class Car {
    private final Engine engine; // HAS-A relationship

    public Car()
    {
        this.engine = new Engine(); // Composition
    }

    public void drive()
    {
        engine.start(); // delegate task to Engine
        System.out.println("Car is driving...");
    }
}


