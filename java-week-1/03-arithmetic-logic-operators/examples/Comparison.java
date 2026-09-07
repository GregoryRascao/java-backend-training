/**
 * This program demonstrates the use of comparison operators in Java.
 * -------------------------------------------------------------
 * 1. Equal to (==)
 * 2. Not equal to (!=)
 * 3. Greater than (>)
 * 4. Less than (<)
 * 5. Greater than or equal to (>=)
 * 6. Less than or equal to (<=)
 *-------------------------------------------------------------
 */

public class Comparison
{

    public static void main(String[] args)
    {
        int x = 10;
        int y = 20;

        // Equal to
        boolean isEqual = (x == y);
        System.out.println("Is Equal: " + isEqual); // Output: Is Equal: false

        // Not equal to
        boolean isNotEqual = (x != y);
        System.out.println("Is Not Equal: " + isNotEqual); // Output: Is Not Equal: true

        // Greater than
        boolean isGreater = (x > y);
        System.out.println("Is Greater: " + isGreater); // Output: Is Greater: false

        // Less than
        boolean isLess = (x < y);
        System.out.println("Is Less: " + isLess); // Output: Is Less: true

        // Greater than or equal to
        boolean isGreaterOrEqual = (x >= y);
        System.out.println("Is Greater or Equal: " + isGreaterOrEqual); // Output: Is Greater or Equal: false

        // Less than or equal to
        boolean isLessOrEqual = (x <= y);
        System.out.println("Is Less or Equal: " + isLessOrEqual); // Output: Is Less or Equal: true
    }
}
