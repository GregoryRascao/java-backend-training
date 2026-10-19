package test2.examples;

/**
 * Example 5: Using Java Assertions
 * 
 * Demonstrates how to use the built-in assert keyword.
 * 
 * IMPORTANT: Run with -ea flag to enable assertions:
 * java -ea testing.examples.Example5
 *
 *
 * In the end: Ask yourself, what are the abilities we cannot have without JUnit?
 * In the end: Ask yourself, what are the principles we're missing in this piece of code?
 */
public class Example5 {
    
    public static void main(String[] args) {
        System.out.println("=== Testing with Assertions ===\n");
        
        // Create a simple calculator to test
        Calculator calc = new Calculator();
        
        // Test addition
        System.out.println("Testing addition...");
        int sum = calc.add(5, 3);
        assert sum == 8 : "5 + 3 should equal 8, but got " + sum;
        System.out.println("✓ Addition works: 5 + 3 = " + sum);
        
        // Test subtraction
        System.out.println("\nTesting subtraction...");
        int diff = calc.subtract(10, 4);
        assert diff == 6 : "10 - 4 should equal 6, but got " + diff;
        System.out.println("✓ Subtraction works: 10 - 4 = " + diff);
        
        // Test multiplication
        System.out.println("\nTesting multiplication...");
        int product = calc.multiply(7, 6);
        assert product == 42 : "7 * 6 should equal 42, but got " + product;
        System.out.println("✓ Multiplication works: 7 * 6 = " + product);
        
        // Test division
        System.out.println("\nTesting division...");
        double quotient = calc.divide(20, 4);
        assert quotient == 5.0 : "20 / 4 should equal 5.0, but got " + quotient;
        System.out.println("✓ Division works: 20 / 4 = " + quotient);
        
        // Test edge case: division by zero
        System.out.println("\nTesting edge case: division by zero...");
        try {
            calc.divide(10, 0);
            assert false : "Should have thrown ArithmeticException";
        } catch (ArithmeticException e) {
            System.out.println("✓ Correctly throws exception for division by zero");
        }
        
        // Test with negative numbers
        System.out.println("\nTesting negative numbers...");
        int negSum = calc.add(-5, -3);
        assert negSum == -8 : "-5 + -3 should equal -8";
        System.out.println("✓ Negative addition works: -5 + -3 = " + negSum);
        
        System.out.println("\n=== All assertions passed! ===");
        System.out.println("\nNote: If assertions are not enabled (-ea flag),");
        System.out.println("all tests will appear to pass even if they fail!");
    }
}

/**
 * Simple Calculator class to demonstrate testing
 */
class Calculator {
    
    public int add(int a, int b) {
        return a + b;   //a fault
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public boolean isPositive(int number) {
        return number > 0;
    }
}
