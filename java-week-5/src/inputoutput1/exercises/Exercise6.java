/**
 *  1. Read input from System.in and store it in a String variable.
 *  2. Create a file whose name is the same as the user's input and write that input into the file.
 *  3. Use Scanner and FileWriter with try-with-resources.
 *  4. After writing, print "File written successfully!".
 *  5. Handle IOException properly.
 */

package inputoutput1.exercises;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise6
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Enter file name: ");
            String input = scanner.nextLine();

            try (FileWriter writer = new FileWriter(input))
            {
                writer.write(input);
                System.out.println("File written successfully!");
            }
            catch (IOException e)
            {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }

    }
}
