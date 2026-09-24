/**
 * 1. Create a File object for the current directory (".").
 * 2. List all files and directories inside it.
 * 3. Print their names and indicate if they are files or directories.
 */

package inputoutput1.examples;
import java.io.File;

public class Example3
{
    public static void main(String[] args)
    {
        File folder = new File(".");

        File[] files = folder.listFiles();

        if (files != null)
        {
            for (File f : files)
            {
                if (f.isDirectory())
                    System.out.println("[DIR] " + f.getName());
                else
                    System.out.println("[FILE] " + f.getName());
            }
        }
    }
}