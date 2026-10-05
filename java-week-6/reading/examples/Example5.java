package reading.examples;
/**
 * Counts the number of lines in a file called "notes.txt".
 */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Stream;

public class Example5
{
    public static void main(String[] args)
    {
        Path filePath = Path.of("resources" + File.separator + "notes.txt");

        try (Stream<String> lines = Files.lines(filePath))
        {
            long count = lines.count();
            System.out.println("Total lines: " + count);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

//        BufferedReader is very good for getting the reading idea
//        Files.lines = modern, short, an alternative friend of Streams
    }
}