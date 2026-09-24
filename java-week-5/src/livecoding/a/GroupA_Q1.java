package livecoding.a;

import java.util.Scanner;

public class GroupA_Q1
{
    public static int readPositiveInt(Scanner scanner)
    {
        while (true)
        {
            System.out.print("Enter a positive integer: ");

            if (!scanner.hasNextInt())
            {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }

            int value = scanner.nextInt();
            if (value <= 0)
            {
                System.out.println("Must be greater than 0");
                continue;
            }

            return value;
        }
    }

    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            int result = readPositiveInt(scanner);
            System.out.println("You entered: " + result);
        }
    }
}
