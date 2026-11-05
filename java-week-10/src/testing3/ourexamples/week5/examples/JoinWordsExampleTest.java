package testing3.ourexamples.week5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JoinWordsExampleTest
{
    private static String[] sharedWords;
    private String[] words;

    @BeforeAll
    static void setUpSuite()
    {
        sharedWords = new String[]{"Modern", "Java", "is", "readable"};
    }

    @BeforeEach
    void setUp()
    {
        words = sharedWords.clone();
    }

    @AfterAll
    static void tearDownSuite()
    {
        sharedWords = null;
    }

    @Test
    void joinCombinesWordsWithSingleSpaces()
    {
        assertEquals("Modern Java is readable", JoinWordsExample.join(words));
    }

    @Test
    void joinHandlesSingleAndEmptyInput()
    {
        assertAll(
                () -> assertEquals("Java", JoinWordsExample.join("Java")),
                () -> assertEquals("", JoinWordsExample.join())
        );
    }
}