package testing3.ourexamples.week7.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Example8Test
{
    private static List<String> sharedLines;
    private List<String> linesForCase;

    @BeforeAll
    static void cacheKeywordLines()
    {
        sharedLines = List.of(
                "Java is great",
                "SQL is marvellous",
                "I like JAVA streams",
                "Java and databases rock"
        );
    }

    @BeforeEach
    void copyKeywordLines()
    {
        linesForCase = new ArrayList<>(sharedLines);
    }

    @AfterAll
    static void releaseKeywordLines()
    {
        sharedLines = null;
    }

    @Test
    void countsKeywordCaseInsensitively()
    {
        assertEquals(3, Example8.countKeyword(linesForCase.stream(), "java"));
    }

    @Test
    void returnsZeroWhenKeywordIsMissing()
    {
        assertEquals(0, Example8.countKeyword(linesForCase.stream(), "python"));
    }
}