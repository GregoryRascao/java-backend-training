/**
 * Reads all lines from "students.txt" into a List<String>.
*/

package reading.examples;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Example6
{
    public static void main(String[] args)
    {
        Path filePath = Path.of("resources" + File.separator + "students.txt");

        try (Stream<String> lines = Files.lines(filePath))
        {
            List<String> students = lines
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();

            System.out.println("Students:");
            students.forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
