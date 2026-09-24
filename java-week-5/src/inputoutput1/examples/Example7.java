/**
 * 1. Use the File class to create a new directory called "resources/new-folder".
 * 2. If the directory already exists, print a message "Directory already exists.".
 * 3. If it is newly created, print "Directory created successfully!"
 * 4. After creation, print the directory’s absolute path.
 */

package inputoutput1.examples;

import java.io.File;

public class Example7
{
    public static void main(String[] args)
    {
        String path = "resources" + File.separator + "new-folder";
        File directory = new File(path);

        if (directory.exists())
        {
            System.out.println("Directory already exists.");
        }
        else if (directory.mkdir())
        {
            System.out.println("Directory created successfully!");
        }
        else
        {
            System.out.println("Failed to create directory.");
        }

        System.out.println("Location: " + directory.getAbsolutePath());
    }
}
