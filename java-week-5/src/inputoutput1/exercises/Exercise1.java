/**
 * 1. Create a File object that points to "resources/info.txt".
 * 2. Check if the file exists.
 * 3. If it exists:
 *      - Print its absolute path.
 *      - Print its size in bytes.
 *      - Check if it’s readable and writable.
 * 4. If it doesn’t exist, print a message saying "File not found!".
 */

package inputoutput1.exercises;

import java.io.File;

public class Exercise1
{
    public static void main(String[] args)
    {
        File file = new File("resources" + File.separator + "info.txt");


    }
}

