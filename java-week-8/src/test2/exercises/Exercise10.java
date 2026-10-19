/**
 * Exercise 10:
 * Practice file I/O testing with @TempDir.
 * This is slightly harder than previous ones — take your time.
 *
 * TODO:
 * 1. Implement writeNames(Path path, List<String> names).
 * 2. The method should:
 *    - trim each name
 *    - ignore empty names
 *    - convert names to uppercase
 *    - write the cleaned names to the file
 * 3. Use @TempDir in a test.
 * 4. Verify:
 *    - the file exists
 *    - the written content is correct
 *
 *     * Work in pairs
 */

package test2.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise10
{
    @TempDir
    Path tempDir;

    static void writeNames(Path path, List<String> names) throws IOException
    {
        // TODO: implement
    }

}
// TODO: write your test here
// this example includes streams

// Hint:
// use Files.write(path, list)
// process names using stream operations (trim, filter, uppercase)