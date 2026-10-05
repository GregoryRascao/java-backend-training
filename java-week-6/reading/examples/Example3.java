/**
 * Counts the number of lines in a file called "notes.txt".
*/

package reading.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Example3
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "notes.txt";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            while (reader.readLine() != null)
            {
                count++;
            }
            System.out.println("Total lines: " + count);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}