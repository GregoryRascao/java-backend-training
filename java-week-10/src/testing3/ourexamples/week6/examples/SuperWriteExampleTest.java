package testing3.ourexamples.week6.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperWriteExampleTest
{
    private static List<Integer> expectedDefaults;
    private List<Number> writableNumbers;

    @BeforeAll
    static void buildExpectedDefaults()
    {
        expectedDefaults = List.of(10, 20, 30);
    }

    @BeforeEach
    void createWritableDestination()
    {
        writableNumbers = new ArrayList<>();
    }

    @AfterAll
    static void dropExpectedDefaults()
    {
        expectedDefaults = null;
    }

    @Test
    void addsThreeDefaultValues()
    {
        SuperWriteExample.addDefaults(writableNumbers);

        assertEquals(expectedDefaults, writableNumbers);
    }

    @Test
    void canWriteIntoObjectList()
    {
        List<Object> writableObjects = new ArrayList<>();

        SuperWriteExample.addDefaults(writableObjects);

        assertAll(
                () -> assertEquals(3, writableObjects.size()),
                () -> assertEquals(10, writableObjects.get(0)),
                () -> assertEquals(30, writableObjects.get(2))
        );
    }
}