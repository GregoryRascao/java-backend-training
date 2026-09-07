/**
 * Exercises:
 * -------------------------------------------------------------
 * 1. Create two new int variables (x and y) with any values.
 * 2. Perform addition, subtraction, multiplication, division,
 *    and modulus using x and y. Print the results.
 *
 * 3. Try division with values that don’t divide evenly
 *    (e.g., 7 / 2) and observe the result.
 * 4. Use double variables for division and compare the
 *    difference between int division and double division.
 * 5. Create three int variables, add them together,
 *    and print the total.
 *
 * Bonus:
 * 6. Calculate the square of a number using multiplication.
 * 7. Calculate the average of three numbers using division.
 * 8. Explore what happens if you divide a number by 0
 *    (hint: try int vs double).
 * -------------------------------------------------------------
 */

public class ArithmeticE
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 3;

        // Addition
        int sum = a + b;
        System.out.println("Sum: " + sum); // Output: Sum: 13

        // Subtraction
        int difference = a - b;
        System.out.println("Difference: " + difference); // Output: Difference: 7

        // Multiplication
        int product = a * b;
        System.out.println("Product: " + product); // Output: Product: 30

        // Division
        int quotient = a / b;
        System.out.println("Quotient: " + quotient); // Output: Quotient: 3

        // Modulus
        int remainder = a % b;
        System.out.println("Remainder: " + remainder); // Output: Remainder: 1


        // -------------------- Student Exercises --------------------
        // 1. Create two int variables x and y, then perform all arithmetic operations.
        int x = 10;
        int y = 3;
        int result;

        // 2. Try division with numbers that don’t divide evenly (e.g., 7 / 2).
        result =  x / y;
        System.out.println("Divided " + result);

        // 3. Use double variables for division and compare with int division.
        double doubleValue = 7.0 / 2.0;
        System.out.println("double division :" +  doubleValue);
        System.out.println("interger double :" + (7 / 2));

 // 4. Create three int variables,
        // add them, and print the total.

        int number1 = 10;
        int number2 = 20;
        int number3 = 30;

        int total = number1 + number2 + number3;

        System.out.println("Total: " + total);


        // 5. Calculate the square of a number.

        int number = 6;

        int square = number * number;

        System.out.println("Square: " + square);


        // 6. Calculate the average of three numbers.

        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        double average = (n1 + n2 + n3) / 3.0;

        System.out.println("Average: " + average);


        // 7. Try dividing a number by 0.

        // int error = 10 / 0;
        // System.out.println(error);

        double infinity = 10.0 / 0;

        System.out.println("Double division by zero: " + infinity);
    }
}
