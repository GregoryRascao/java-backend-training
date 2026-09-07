package methods.examples;

/**
 * Example 3: Overloading & Overriding
 * ---------------------------------
 * This example demonstrates method overloading and method overriding in Java.
 */
public class Example3
{
    public static void main(String[] args)
    {
        // Method Overloading
        Calculator calc = new Calculator();
        System.out.println("Add int: " + calc.add(2, 3));
        System.out.println("Add double: " + calc.add(2.5, 3.5));

        // Method Overriding
        Animal a1 = new Animal();
        a1.sound();  // parent version
        Animal a2 = new Dog();
        a2.sound();  // overridden version
    }
}


class Calculator
{
    // Method Overloading: same name, different parameters
    public int add(int a, int b)
    {
        return a + b;
    }

    public double add(double a, double b)
    {
        return a + b;
    }
}

// Parent class
class Animal
{
    public void sound()
    {
        System.out.println("Animal makes a sound");
    }
}

// Child class overriding parent method
class Dog extends Animal
{
    @Override
    public void sound()
    {
        System.out.println("Dog barks");
    }
}

