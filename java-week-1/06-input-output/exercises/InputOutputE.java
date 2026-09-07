/**
 * Exercises: Input and Output in Java
 * -----------------------------------------------------
 * This program demonstrates safe input handling:
 * 1. Output
 *   - System.out.print(): Prints text without a newline.
 *   - System.out.println(): Prints text with a newline.
 *   - System.out.printf(): Prints formatted text.
 *
 * 2. Input (using Scanner)
 *   - nextLine(): Reads a line of text.
 *   - nextInt(): Reads an integer.
 *   - nextDouble(): Reads a double.
 *   - next(): Reads a single word.
 *
 * -----------------------------------------------------
 */

import java.util.Scanner;

public class InputOutputE
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Output examples
        System.out.print("This is printed without a newline. ");
        System.out.println("This is printed with a newline.");
        System.out.printf("Formatted number: %.2f%n", 123.456);

        // 1. Reading a full line safely
        String line;
        System.out.print("Enter a line of text: ");
        while (!scanner.hasNextLine())
        {
            System.out.println("Invalid input. Please enter a line of text:");
            scanner.next(); // discard invalid token
        }
        line = scanner.nextLine();
        System.out.println("You entered: " + line);

        // 2. Reading an integer safely
        int number;
        while (true)
        {
            System.out.print("Enter an integer: ");
            if (scanner.hasNextInt())
            {
                number = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // discard invalid token
            }
        }
        System.out.println("You entered: " + number);

        // 3. Reading a double safely
        double decimal;
        while (true)
        {
            System.out.print("Enter a double: ");
            if (scanner.hasNextDouble())
            {
                decimal = scanner.nextDouble();
                scanner.nextLine(); // consume leftover newline
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.next(); // discard invalid token
            }
        }
        System.out.println("You entered: " + decimal);

        // 4. Reading a single word safely
        String word;
        while (true)
        {
            System.out.print("Enter a single word: ");
            if (scanner.hasNext())
            {
                word = scanner.next();
                scanner.nextLine(); // consume leftover newline
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter a word.");
                scanner.next(); // discard invalid token
            }
        }
        System.out.println("You entered: " + word);

        scanner.close();
    }
}
