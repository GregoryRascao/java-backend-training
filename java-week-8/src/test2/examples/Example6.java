package test2.examples;

/**
 * Example 6: Custom Assertion Methods
 * 
 * Demonstrates creating your own assertion methods without external libraries.
 * These work like JUnit assertions but are more basic.
 * In the end: Ask yourself, what are the abilities we cannot have with JUnit?
 * In the end: Ask yourself, what are the principles we're missing?
 */
public class Example6 {
    
    public static void main(String[] args) {
        System.out.println("=== Custom Assertion Methods ===\n");
        
        // Create test subject
        StringUtils utils = new StringUtils();
        
        // Track test results
        int passed = 0;
        int failed = 0;
        int total = 0;
        
        // Test 1: Reverse string
        System.out.println("Test 1: Reversing a string");
        total++;
        try {
            String result = utils.reverse("hello");
            assertEquals("olleh", result, "reverse('hello') should return 'olleh'");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Test 2: Empty string
        System.out.println("\nTest 2: Reversing empty string");
        total++;
        try {
            String result = utils.reverse("");
            assertEquals("", result, "reverse('') should return ''");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Test 3: Check if palindrome
        System.out.println("\nTest 3: Checking palindrome");
        total++;
        try {
            assertTrue(utils.isPalindrome("racecar"), "'racecar' should be a palindrome");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Test 4: Not a palindrome
        System.out.println("\nTest 4: Checking non-palindrome");
        total++;
        try {
            assertFalse(utils.isPalindrome("hello"), "'hello' should not be a palindrome");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Test 5: Null handling
        System.out.println("\nTest 5: Handling null input");
        total++;
        try {
            assertThrows(IllegalArgumentException.class, 
                () -> utils.reverse(null),
                "reverse(null) should throw IllegalArgumentException");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Test 6: Count words
        System.out.println("\nTest 6: Counting words");
        total++;
        try {
            int count = utils.countWords("Hello world from Java");
            assertEquals(4, count, "Should count 4 words");
            System.out.println("✓ PASSED");
            passed++;
        } catch (AssertionError e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            failed++;
        }
        
        // Print summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results:");
        System.out.println("  Total: " + total);
        System.out.println("  Passed: " + passed + " ✓");
        System.out.println("  Failed: " + failed + " ✗");
        System.out.println("=".repeat(50));
        
        if (failed == 0) {
            System.out.println("\n🎉 All tests passed!");
        } else {
            System.out.println("\n⚠️  " + failed + " tests failed.");
        }
    }
    
    // ========== Custom Assertion Methods ==========
    
    public static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + 
                " - Expected: '" + expected + "', but got: '" + actual + "'");
        }
    }
    
    public static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + 
                " - Expected: " + expected + ", but got: " + actual);
        }
    }
    
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message + " - Expected: true, but got: false");
        }
    }
    
    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message + " - Expected: false, but got: true");
        }
    }
    
    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new AssertionError(message + " - Expected: not null, but got: null");
        }
    }
    
    public static void assertNull(Object object, String message) {
        if (object != null) {
            throw new AssertionError(message + " - Expected: null, but got: " + object);
        }
    }
    
    public static void assertThrows(Class<? extends Exception> expectedException,
                                   Runnable code,
                                   String message) {
        try {
            code.run();
            throw new AssertionError(message + 
                " - Expected exception: " + expectedException.getSimpleName() + 
                ", but no exception was thrown");
        } catch (Exception e) {
            if (!expectedException.isInstance(e)) {
                throw new AssertionError(message + 
                    " - Expected: " + expectedException.getSimpleName() + 
                    ", but got: " + e.getClass().getSimpleName());
            }
        }
    }
}

/**
 * String utility class to demonstrate testing
 */
class StringUtils {
    
    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }
    
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String reversed = reverse(input);
        return input.equalsIgnoreCase(reversed);
    }
    
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }
    
    public boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
