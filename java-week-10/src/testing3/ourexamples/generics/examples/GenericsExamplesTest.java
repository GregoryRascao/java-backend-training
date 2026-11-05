package testing3.ourexamples.generics.examples;
/*
This file is not yet prepared, still in progress

import generics2.examples.Example1UnboundedWildcard;
import generics2.examples.Example2ExtendsRead;
import generics2.examples.Example3SuperWrite;
import generics2.examples.Example4Pecs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


 // Tests for classes under generics2.examples using plain Java assertions.

public class GenericsExamplesTest {

    public static void main(String[] args) {
        int total = 0;
        int passed = 0;

        total++; if (testPrintList()) passed++;
        total++; if (testSumNumbers()) passed++;
        total++; if (testAddDefaults()) passed++;
        total++; if (testCopyElements()) passed++;

        System.out.println("Results: " + passed + "/" + total + " tests passed.");
    }

    private static boolean testPrintList() {
        String testName = "Example1UnboundedWildcard.printList";
        try {
            String output = captureOutput(() -> Example1UnboundedWildcard.printList(Arrays.asList("A", "B")));
            assertEquals("A\nB", output, "printList should print each item on a new line");
            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testSumNumbers() {
        String testName = "Example2ExtendsRead.sumNumbers";
        try {
            double intSum = Example2ExtendsRead.sumNumbers(Arrays.asList(1, 2, 3));
            double doubleSum = Example2ExtendsRead.sumNumbers(Arrays.asList(1.5, 2.5));

            assertDoubleEquals(6.0, intSum, 0.0001, "sumNumbers should sum integer list");
            assertDoubleEquals(4.0, doubleSum, 0.0001, "sumNumbers should sum double list");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testAddDefaults() {
        String testName = "Example3SuperWrite.addDefaults";
        try {
            List<Number> numbers = new ArrayList<>();
            Example3SuperWrite.addDefaults(numbers);

            assertEquals(3, numbers.size(), "addDefaults should add 3 numbers");
            assertEquals(Arrays.asList(10, 20, 30), numbers, "addDefaults should add 10,20,30");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testCopyElements() {
        String testName = "Example4Pecs.copyElements";
        try {
            List<Integer> source = Arrays.asList(7, 8, 9);
            List<Number> destination = new ArrayList<>();

            Example4Pecs.copyElements(source, destination);

            assertEquals(Arrays.asList(7, 8, 9), destination, "copyElements should copy all source values");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static String captureOutput(Runnable runnable) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(baos));
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }

        return baos.toString().replace("\r\n", "\n").trim();
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " - expected: " + expected + ", actual: " + actual);
        }
    }

    private static void assertDoubleEquals(double expected, double actual, double delta, String message) {
        if (Math.abs(expected - actual) > delta) {
            throw new AssertionError(message + " - expected: " + expected + ", actual: " + actual);
        }
    }


}
 */