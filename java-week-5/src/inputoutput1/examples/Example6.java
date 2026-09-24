/**
 * 1. Write a program that reads a file and creates a copy of it.
 * 2. Use FileInputStream and FileOutputStream (byte streams).
 * 3. Print a message once the copy is complete.
 */

package inputoutput1.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6
{
    public static void main(String[] args)
    {
        String dir = "resources" + File.separator;
        try (
                FileInputStream input = new FileInputStream(dir + "cat.jpeg");
                FileOutputStream output = new FileOutputStream(dir + "copy.jpeg")
        )
        {
            int byteData;
            while ((byteData = input.read()) != -1)
            {
                output.write(byteData);
            }
            System.out.println("File copied successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}