package exceptions.exercises;

/**
 * Exercise 1:
 * Write a program that divides two numbers.
 * Catch ArithmeticException when dividing by zero.
 * Print a friendly error message.
 */

public class Exercise1
{
    public static void main(String[] args)
    {
        int number1 = 10;
        int number2 = 0;

        try {
            int result = number1 / number2;
            System.out.println("Resultat :" + result);
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println("Error : Not permit");
        }

    }

}




