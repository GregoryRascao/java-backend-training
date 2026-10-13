/**
 * Writes a list of names into a file, one per line.
*/

package writing.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Example4
{
    public static void main(String[] args)
    {
        String filePath = "resources" + File.separator + "names.txt";
        List<String> names = Arrays.asList("Alice    ", "", "    Bob", "charlie", "diana");
        List<String> cleanedNames = names.stream()
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(String::toUpperCase)
                .toList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (String name : cleanedNames)
            {
                writer.write(name);
                writer.newLine();
                // writer.flush(); what happens with or without?
            }
            System.out.println("Names written successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}