/**
 * Unary Operators Example
 * -----------------------
 * 1. Unary Minus (-): Negates the value of its operand.
 * 2. Unary Plus (+): Indicates a positive value (though it's optional).
 * 3. Logical NOT (!): Inverts the boolean value of its operand.
 * 4. Increment (++) and Decrement (--): Increase or decrease a value by one.
 */

public class Unary
{
    public static void main(String[] args) {
        int a = 5;
        int b = -a; // Unary minus
        int c = +a; // Unary plus
        boolean flag = true;
        boolean notFlag = !flag; // Logical NOT
        int x = 10;
        x++; // Increment
        int y = 10;
        y--; // Decrement

        System.out.println("Original a: " + a);
        System.out.println("Unary minus b: " + b);
        System.out.println("Unary plus c: " + c);
        System.out.println("Original flag: " + flag);
        System.out.println("Logical NOT notFlag: " + notFlag);
        System.out.println("Incremented x: " + x);
        System.out.println("Decremented y: " + y);
    }
}
