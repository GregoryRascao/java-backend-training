package testing3.ourexamples.week5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericMethodsExampleTest
{
    private static List<Integer> sharedIntegers;
    private static List<Double> sharedDoubles;
    private List<Integer> integers;
    private List<Double> doubles;
    private NumberBoxExample<Integer> integerBox;
    private NumberBoxExample<Double> negativeDoubleBox;

    @BeforeAll
    static void setUpSuite()
    {
        sharedIntegers = List.of(10, 20, 30, 40);
        sharedDoubles = List.of(1.5, 2.5, 3.5);
    }

    @BeforeEach
    void setUp()
    {
        integers = new ArrayList<>(sharedIntegers);
        doubles = new ArrayList<>(sharedDoubles);
        integerBox = new NumberBoxExample<>(42);
        negativeDoubleBox = new NumberBoxExample<>(-2.5);
    }

    @AfterAll
    static void tearDownSuite()
    {
        sharedIntegers = null;
        sharedDoubles = null;
    }

    @Test
    void findMaxReturnsLargestComparableValue()
    {
        assertAll(
                () -> assertEquals(7, GenericMethodsExample.findMax(3, 7, 2)),
                () -> assertEquals("zebra", GenericMethodsExample.findMax("apple", "zebra", "banana"))
        );
    }

    @Test
    void sumAndAverageWorkForNumberLists()
    {
        assertAll(
                () -> assertEquals(100.0, GenericMethodsExample.sumNumbers(integers)),
                () -> assertEquals(2.5, GenericMethodsExample.average(doubles)),
                () -> assertEquals(0.0, GenericMethodsExample.average(List.of()))
        );
    }

    @Test
    void numberBoxConvertsAndChecksSigns()
    {
        assertAll(
                () -> assertEquals(42, integerBox.getValue()),
                () -> assertEquals(42.0, integerBox.toDouble()),
                () -> assertEquals(42, integerBox.toInt()),
                () -> assertTrue(integerBox.isPositive()),
                () -> assertFalse(integerBox.isNegative()),
                () -> assertFalse(negativeDoubleBox.isPositive()),
                () -> assertTrue(negativeDoubleBox.isNegative())
        );
    }
}