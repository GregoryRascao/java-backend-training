/**
 * Example 10:
 * Testing file output safely with @TempDir.
 *
 * Ask yourself
 * Why is this deterministic?
 *
 */

package test3.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Example10
{
    static void writeUppercase(Path path, List<String> lines) throws IOException
    {
        List<String> processed = lines.stream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Files.write(path, processed);
    }

    @TempDir
    Path tempDir;

    @Test
    void writesProcessedLinesToTemporaryFile() throws IOException
    {
        Path output = tempDir.resolve("cities.txt");

        writeUppercase(output, List.of(" Brussels ", "", "Ghent"));

        assertTrue(Files.exists(output));
        assertIterableEquals(List.of("BRUSSELS", "GHENT"), Files.readAllLines(output));
        assertEquals(List.of("BRUSSELS", "GHENT"), Files.readAllLines(output));
        // Both assertions work here because List.equals() compares elements in order.
        // assertIterableEquals explicitly checks iterable contents and their order.
    }
}