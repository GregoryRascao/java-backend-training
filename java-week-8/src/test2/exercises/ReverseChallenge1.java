package test2.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Reverse challenge: Try to guess what the code should do
 * separate the tests to different test methods
 *
 * Work in pairs
 */

public class ReverseChallenge1 {

    @TempDir
    Path tempDir;

    @Test
    void shouldWriteOnlyErrorLines() throws IOException {
        Path output = tempDir.resolve("errors.txt");

        /*uncomment this
        saveErrorsOnly(output, List.of(
                "INFO App started",
                "ERROR Database down",
                "WARN Low memory",
                " ERROR Disk full ",
                "",
                "INFO User login"
        ));
        */

        assertTrue(Files.exists(output));
        assertEquals(
                List.of("ERROR Database down", "ERROR Disk full"),
                Files.readAllLines(output)
        );
    }
}


/**
 * Hints
 *
 Think about:

 - Which lines should be kept?
 - Should spaces be removed?
 - What should happen to empty lines?
 */