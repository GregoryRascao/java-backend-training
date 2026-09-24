/**
 * 1. Create a method that accepts varargs.
 * 2. Sum all numbers.
 * 3. Call the method with different number of arguments.
 */

package modern.examples;

public class Example1
{
    public static int sum(int... numbers)
    {
        int total = 0;
        for (int number : numbers)
        {
            total += number;
        }
        return total;
    }

    public static void main(String[] args)
    {
        System.out.println("sum(1, 2) = " + sum(1, 2));
        System.out.println("sum(1, 2, 3, 4) = " + sum(1, 2, 3, 4));
    }
}
