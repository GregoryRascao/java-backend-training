/**
 * Example 2:
 * Read a file using Files.lines() and print only the lines
 * that contain the word "java".
 *
 * Steps:
 * 1. Read all lines as a Stream<String>
 * 2. Ignore empty lines
 * 3. Filter lines containing the keyword
 * 4. Print them
 */


package reading.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Example2
{
    public static void main(String[] args)
    {
        Path filePath = Path.of("resources" + File.separator + "notes.txt");
        String keyword = "java";

        try (Stream<String> lines = Files.lines(filePath))
        {
            lines
                    .filter(line -> !line.isBlank())
                    .filter(line -> line.toLowerCase().contains(keyword))
                    .forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
