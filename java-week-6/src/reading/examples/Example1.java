/**
 * Reads lines from "message.txt" using BufferedReader for efficiency.
 */

package reading.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Example1
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "message.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)  //readLine() returns null when the end of the file is reached
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
