/**
 * Reads all lines from "students.txt" into a List<String>.
*/

package reading.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example4
{
    public static void main(String[] args)
    {
        List<String> students = new ArrayList<>();
        String filePath = "resources" + File.separator + "students.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                students.add(line);
            }

            System.out.println("Students:");
            students.forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
