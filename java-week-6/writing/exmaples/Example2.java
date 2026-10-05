/**
 * Demonstrates appending new data to an existing file.
 */

package writing.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example2
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "log.txt";
        try (FileWriter writer = new FileWriter(filePath, true))
        {
            writer.write("New log entry: Application started.\n");
            System.out.println("Data appended successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error appending data: " + e.getMessage());
        }
    }
}
