/**
 * Demonstrates flushing a stream manually before closing.
 */
package writing.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example5
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "example.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write("This text is written and flushed.");
            // flush() sends buffered data to disk now, but keeps the writer open.

            // flush() is useful when writing logs or streaming data,
            // where you want data to appear immediately in the file.
            writer.flush();
            // close() is called automatically at the end of try-with-resources.
            System.out.println("File flushed and closed successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
