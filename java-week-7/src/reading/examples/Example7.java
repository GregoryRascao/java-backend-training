package reading.examples;

/**
 * Example 7:
 * Demonstrates a simple test for a file-processing function.
 *
 * Instead of putting all logic inside main(), we move the logic
 * into a method that can be tested independently.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Example7
{
    public static void main(String[] args) throws IOException
    {
        Path path = Path.of("resources/lines.txt");

        int result = countLines(path);

        // simple manual test
        int expected = 5;   // adjust to match your test file

        if (result == expected)
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
            System.out.println("Expected: " + expected + ", got: " + result);
        }
    }

    public static int countLines(Path path) throws IOException
    {
        try (Stream<String> lines = Files.lines(path))
        {
            return (int) lines.count();
        }
    }
}