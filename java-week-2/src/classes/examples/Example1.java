package classes.examples;

/**
 * Example 1: Basic Class
 * - Fields, Methods, and Object Creation
 */

public class Example1
{
    public static void main(String[] args)
    {
        Car car1 = new Car();
        car1.color = "Red";
        car1.speed = 120;
        car1.drive();
    }
}

class Car
{
    String color;
    int speed;

    void drive()
    {
        System.out.println(color + " car is driving at " + speed + " km/h");
    }
}


