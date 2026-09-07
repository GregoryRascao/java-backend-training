/**
 * This program demonstrates basic arithmetic operations in Java.
 * -------------------------------------------------------------
 * 1. Addition
 * 2. Subtraction
 * 3. Multiplication
 * 4. Division
 * 5. Modulus
 *-------------------------------------------------------------
 */

public class Arithmetic
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 3;
        int result;

        // + sign inside System.out, and parantheses
        System.out.println("Hello" + " " + "World" + (a+b) );

        result = a+b;   //addition
        System.out.println("Added: " + result);

        result = a-b;
        System.out.println("Subtracted: " + result);

        result = a*b;
        System.out.println("multiplied" + result);

        float f = 10.5f;
        System.out.println(b * f);
        System.out.println("Float and int multiplied: " + f * b);


        //result is int
        //result = (float)a / (float)b; //not possible
        result = a / b;
        System.out.println(result);

        System.out.println( a / b );


        result = a % b; //modulus operator will give us the remainder
        System.out.println("Modulus operation: " + result);
    }
}