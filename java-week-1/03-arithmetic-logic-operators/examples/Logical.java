/**
 * Logical Operators
 * -----------------
 * 1. && (Logical AND)
 * 2. || (Logical OR)
 * 3. ! (Logical NOT)
 */

public class Logical
{
    public static void main(String[] args)
    {
        boolean a = true;
        boolean b = false;

        // Logical AND
        System.out.println("Logical AND (&&):");
        System.out.println("true && true = " + (a && a));   // true
        System.out.println("true && false = " + (a && b));  // false
        System.out.println("false && false = " + (b && b)); // false

        // Logical OR
        System.out.println("\nLogical OR (||):");
        System.out.println("true || true = " + (a || a));   // true
        System.out.println("true || false = " + (a || b));  // true
        System.out.println("false || false = " + (b || b)); // false

        // Logical NOT
        System.out.println("\nLogical NOT (!):");
        System.out.println("!true = " + (!a));   // false
        System.out.println("!false = " + (!b));  // true
    }
}
