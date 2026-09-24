/**
 * 1. Create a File object pointing to a file called "notes.txt".
 * 2. Check if the file exists.
 * 3. If it doesn’t, print a message saying "File not found!".
 */

package inputoutput1.examples;

import java.io.File;

public class Example1
{
    public static void main(String[] args)
    {
        File file = new File("notes.txt");

        if (file.exists())
        {
            System.out.println("File exists: " + file.getAbsolutePath());
        }
        else
        {
            System.out.println("File not found!");
        }
    }
}