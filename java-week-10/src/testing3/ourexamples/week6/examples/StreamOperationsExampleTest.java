package testing3.ourexamples.week6.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamOperationsExampleTest
{
    private static List<String> rawNamesTemplate;
    private static List<String> productsTemplate;
    private static List<Integer> pricesTemplate;
    private List<String> rawNames;
    private List<String> products;
    private List<Integer> prices;

    @BeforeAll
    static void cacheSharedInputs()
    {
        rawNamesTemplate = List.of("  alice", "Bob  ", "  charlie  ");
        productsTemplate = List.of("Book", "Pen", "Book", "Laptop", "Pencil", "Pen");
        pricesTemplate = List.of(25, 5, 25, 900, 3, 5);
    }

    @BeforeEach
    void cloneInputsForTest()
    {
        rawNames = new ArrayList<>(rawNamesTemplate);
        products = new ArrayList<>(productsTemplate);
        prices = new ArrayList<>(pricesTemplate);
    }

    @AfterAll
    static void disposeSharedInputs()
    {
        rawNamesTemplate = null;
        productsTemplate = null;
        pricesTemplate = null;
    }

    @Test
    void normalizesNamesToTrimmedUppercase()
    {
        assertEquals(List.of("ALICE", "BOB", "CHARLIE"), StreamOperationsExample.normalizeNames(rawNames));
    }

    @Test
    void returnsUniqueSortedProductNames()
    {
        assertEquals(List.of("Book", "Laptop", "Pen", "Pencil"), StreamOperationsExample.uniqueSortedProductNames(products));
    }

    @Test
    void calculatesTotalPrice()
    {
        assertEquals(963, StreamOperationsExample.totalPrice(prices));
    }

    @Test
    void returnsHighestPriceWhenListIsNotEmpty()
    {
        Optional<Integer> highestPrice = StreamOperationsExample.highestPrice(prices);

        assertTrue(highestPrice.isPresent());
        assertEquals(900, highestPrice.orElseThrow());
    }

    @Test
    void groupsNamesByInitial()
    {
        Map<Character, Long> counts = StreamOperationsExample.countByInitial(List.of("Alice", "Adam", "Bob", "Bella", "Charlie"));

        assertAll(
                () -> assertEquals(2L, counts.get('A')),
                () -> assertEquals(2L, counts.get('B')),
                () -> assertEquals(1L, counts.get('C'))
        );
    }
}