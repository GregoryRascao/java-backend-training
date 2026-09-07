/**
 * Exercises:
 * -------------------------------------------------------------
 * 1. Create two boolean variables x = true, y = false.
 *    - Use && to check if both are true.
 *    - Use || to check if at least one is true.
 *    - Use ! to invert their values and print results.
 *
 * 2. Create three boolean variables a = true, b = false, c = true.
 *    - Evaluate the expression: (a && b) || c and print the result.
 *    - Evaluate the expression: !(a || b) && c and print the result.
 *
 * 3. Write a condition to check if a number n = 15 is:
 *    - Greater than 10 **AND** less than 20.
 *    - Not equal to 12 **OR** less than 5.
 *
 * Bonus:
 * 4. Combine multiple logical operators with parentheses
 *    to control the order of evaluation and test different cases.
 * -------------------------------------------------------------
 */

public class LogicalE
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


        // -------------------- Student Exercises --------------------
        // 1. Create boolean x = true, y = false and test &&, ||, ! operators.

        // 2. Create a = true, b = false, c = true; evaluate:
        //    (a && b) || c and !(a || b) && c

        // 3. Create int n = 15; check if n > 10 && n < 20,
        //    and n != 12 || n < 5.

        // 4. Combine multiple logical operators with parentheses
        //    to test order of evaluation.
    }
}
