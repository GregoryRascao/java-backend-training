package testing3.ourexamples.week7.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Example7Test
{
    private static List<String> sharedLines;
    @TempDir
    Path tempDir;
    private Path notesFile;

    @BeforeAll
    static void rememberSharedFileLines()
    {
        sharedLines = List.of("alpha", "beta", "gamma", "delta");
    }

    @BeforeEach
    void createTemporaryNotesFile() throws IOException
    {
        notesFile = tempDir.resolve("notes.txt");
        Files.write(notesFile, sharedLines);
    }

    @AfterAll
    static void forgetSharedFileLines()
    {
        sharedLines = null;
    }

    @Test
    void countsAllLinesInFile() throws IOException
    {
        assertEquals(4, Example7.countLines(notesFile));
    }

    @Test
    void countsEmptyFileAsZeroLines() throws IOException
    {
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.write(emptyFile, List.of());

        assertEquals(0, Example7.countLines(emptyFile));
    }
}