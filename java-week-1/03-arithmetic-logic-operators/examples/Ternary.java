/**
 * Ternary Operator Example
 * -----------------------
 * This class demonstrates the use of the ternary operator in Java.
 * The ternary operator is a shorthand for an if-else statement and is used to assign
 * a value based on a condition.
 */

public class Ternary
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;

        // conditions ?  value if true : value if false
        // Using the ternary operator to find the maximum of two numbers
        int max = (a > b) ? a : b;

        System.out.println("The maximum value is: " + max);
    }
}
