package methods.examples;

/**
 * Example 4: Special Methods in Java
 * - Varargs
 * - Constructors
 * - Abstract methods
 * - main() as entry point
 */


public class Example4
{
    // Constructor
    public Example4()
    {
        System.out.println("Constructor called");
    }

    // main method
    public static void main(String[] args)
    {
        // Constructor
        Example4 obj = new Example4 ();

        // Varargs
        obj.printNumbers(1, 2, 3, 4, 5);

        // Abstract method via subclass
        Form form = new Circle();
        form.draw();
    }

    // Varargs method
    public void printNumbers(int... numbers)
    {
        System.out.print("Numbers: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


// Abstract class with abstract method
abstract class Form
{
    public abstract void draw(); // abstract method (no body)
}

class Circle extends Form
{
    @Override
    public void draw()
    {
        System.out.println("Drawing a Circle");
    }
}
