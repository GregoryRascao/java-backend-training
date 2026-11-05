package testing3.ourexamples.week6.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtendsReadExampleTest
{
    private static List<Integer> sampleIntegers;
    private List<Integer> numbersForTest;

    @BeforeAll
    static void loadReferenceNumbers()
    {
        sampleIntegers = List.of(1, 2, 3, 4);
    }

    @BeforeEach
    void copyNumbersForCase()
    {
        numbersForTest = new ArrayList<>(sampleIntegers);
    }

    @AfterAll
    static void releaseReferenceNumbers()
    {
        sampleIntegers = null;
    }

    @Test
    void sumsIntegerList()
    {
        assertEquals(10.0, ExtendsReadExample.sumNumbers(numbersForTest));
    }

    @Test
    void sumsDoubleList()
    {
        assertEquals(4.0, ExtendsReadExample.sumNumbers(List.of(1.5, 2.5)));
    }
}