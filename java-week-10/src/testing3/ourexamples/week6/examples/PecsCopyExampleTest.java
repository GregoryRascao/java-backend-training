package testing3.ourexamples.week6.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PecsCopyExampleTest
{
    private static List<Integer> sourceTemplate;
    private List<Number> destinationNumbers;

    @BeforeAll
    static void prepareSourceTemplate()
    {
        sourceTemplate = List.of(7, 8, 9);
    }

    @BeforeEach
    void startWithEmptyDestination()
    {
        destinationNumbers = new ArrayList<>();
    }

    @AfterAll
    static void clearSourceTemplate()
    {
        sourceTemplate = null;
    }

    @Test
    void copiesAllElementsIntoNumberList()
    {
        PecsCopyExample.copyElements(sourceTemplate, destinationNumbers);

        assertEquals(List.of(7, 8, 9), destinationNumbers);
    }

    @Test
    void appendsToExistingDestination()
    {
        destinationNumbers.add(1.5);

        PecsCopyExample.copyElements(sourceTemplate, destinationNumbers);

        assertAll(
                () -> assertEquals(4, destinationNumbers.size()),
                () -> assertEquals(1.5, destinationNumbers.get(0)),
                () -> assertEquals(9, destinationNumbers.get(3))
        );
    }
}