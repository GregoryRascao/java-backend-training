package testing3.ourexamples.week3.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest
{
    private static String productName;
    private Product trackedProduct;

    @BeforeAll
    static void rememberProductName()
    {
        productName = "Keyboard";
    }

    @BeforeEach
    void createProductUnderTest()
    {
        trackedProduct = new Product(productName, 100.0);
    }

    @AfterAll
    static void forgetProductName()
    {
        productName = null;
    }

    @Test
    void constructorStoresNameAndPrice()
    {
        assertAll(
                () -> assertEquals("Keyboard", trackedProduct.getName()),
                () -> assertEquals(100.0, trackedProduct.getPrice())
        );
    }

    @Test
    void negativePriceUpdateIsIgnored()
    {
        trackedProduct.setPrice(-10.0);

        assertEquals(100.0, trackedProduct.getPrice());
    }

    @Test
    void validDiscountReducesPrice()
    {
        trackedProduct.applyDiscount(25.0);

        assertEquals(75.0, trackedProduct.getPrice());
    }

    @Test
    void invalidDiscountLeavesPriceUnchanged()
    {
        trackedProduct.applyDiscount(60.0);

        assertEquals(100.0, trackedProduct.getPrice());
    }
}