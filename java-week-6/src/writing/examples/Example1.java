/**
 * Demonstrates writing multiple lines using BufferedWriter.
 */

package writing.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example1
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "lines.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write("First line of text");
            writer.newLine();
            writer.write("Second line of text");
            writer.newLine();
            writer.write("Third line of text");
            System.out.println("All lines written successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}