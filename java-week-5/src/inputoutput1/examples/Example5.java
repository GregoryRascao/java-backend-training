/**
 * 1. Use FileWriter to write "Hello, Java!" into a file called "output.txt".
 * 2. Use try-with-resources for automatic closing.
 * 3. Run the program and verify the file content.
 */

package inputoutput1.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Example5
{
    public static void main(String[] args)
    {
        String path = "resources" + File.separator + "output.txt";
        try (FileWriter writer = new FileWriter(path))
        {
            writer.write("Hello, Java!\n");
            writer.write("File I/O is easy to learn.");
            System.out.println("Data successfully written to file.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}