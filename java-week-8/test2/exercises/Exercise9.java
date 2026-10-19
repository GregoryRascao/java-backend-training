/**
 * Exercise 9:
 * Practice assertAll and exception testing.
 *
 * TODO:
 * 1. Create a class Product with:
 *    - name
 *    - price
 * 2. In the constructor:
 *    - throw IllegalArgumentException if price is negative
 *    - use the message: "Price cannot be negative"
 * 3. Write one test with assertAll(...) to check multiple values of a valid Product.
 * 4. Write one test with assertThrows(...) and verify the exception message.
 *
 * Test both:
 * - valid product
 * - invalid product
 *
 * Bonus:
 * test boundary values like price = 0
 *
 */

package test2.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise9
{
    // TODO: create Product class here

    // TODO: write your tests here
}

// Hint:
// create getters for name and price
