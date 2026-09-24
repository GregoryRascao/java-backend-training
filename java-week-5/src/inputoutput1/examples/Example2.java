/**
 * 1. Use the File class to create a new file called "data.txt".
 * 2. Check if the file was created successfully.
 * 3. Print the absolute path.
 */

package inputoutput1.examples;

import java.io.File;
import java.io.IOException;

public class Example2
{
    public static void main(String[] args)
    {
        // Define a safe, OS-independent file path
        String path = "resources" + File.separator + "data.txt";
        File file = new File(path);
        try {
            // Try to create the file
            if (file.createNewFile())
            {
                System.out.println("File created successfully!");
                System.out.println("Location: " + file.getAbsolutePath());
            }
            else
            {
                System.out.println("File already exists at: " + file.getAbsolutePath());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
