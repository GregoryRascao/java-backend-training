package testing3.ourexamples.generics.exercises;

/**
 * This file is not yet prepared, still in progress
 * Tests for classes under generics2.exercises using plain Java assertions.
 */
public class GenericsExercisesTest {
/*
    public static void main(String[] args) {
        int total = 0;
        int passed = 0;

        total++; if (testExercise1SumNumbers()) passed++;
        total++; if (testExercise1AddDefaults()) passed++;
        total++; if (testExercise1Copy()) passed++;
        total++; if (testExercise3Sum()) passed++;
        total++; if (testExercise3PrintAll()) passed++;
        total++; if (testExercise2MainOutput()) passed++;

        System.out.println("Results: " + passed + "/" + total + " tests passed.");
    }

    private static boolean testExercise1SumNumbers() {
        String testName = "Exercise1.sumNumbers";
        try {
            double sumInts = Exercise1.sumNumbers(Arrays.asList(1, 2, 3, 4));
            double sumDoubles = Exercise1.sumNumbers(Arrays.asList(1.5, 2.5));

            assertDoubleEquals(10.0, sumInts, 0.0001, "sumNumbers should sum integers correctly");
            assertDoubleEquals(4.0, sumDoubles, 0.0001, "sumNumbers should sum doubles correctly");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testExercise1AddDefaults() {
        String testName = "Exercise1.addDefaults";
        try {
            List<Object> values = new ArrayList<>();
            Exercise1.addDefaults(values);

            assertEquals(3, values.size(), "addDefaults should add exactly 3 values");
            assertEquals(Arrays.asList(1, 2, 3), values, "addDefaults should add 1,2,3");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testExercise1Copy() {
        String testName = "Exercise1.copy";
        try {
            List<Integer> source = Arrays.asList(5, 6, 7);
            List<Number> destination = new ArrayList<>();

            Exercise1.copy(source, destination);

            assertEquals(Arrays.asList(5, 6, 7), destination, "copy should copy source values into destination");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testExercise3Sum() {
        String testName = "Exercise3.sum";
        try {
            double sum = Exercise3.sum(Arrays.asList(3, 6, 9));
            assertDoubleEquals(18.0, sum, 0.0001, "sum should return total for numeric list");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testExercise3PrintAll() {
        String testName = "Exercise3.printAll";
        try {
            String output = captureOutput(() -> Exercise3.printAll(Arrays.asList("x", "y", "z")));
            assertEquals("x\ny\nz", output, "printAll should print all elements line by line");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testExercise2MainOutput() {
        String testName = "Exercise2.main validators";
        try {
            String output = captureOutput(() -> Exercise2.main(new String[0]));
            String[] lines = output.split("\\n");
            List<String> booleans = new ArrayList<>();

            for (String line : lines) {
                String value = line.trim();
                if ("true".equals(value) || "false".equals(value)) {
                    booleans.add(value);
                }
            }

            assertEquals(4, booleans.size(), "Exercise2.main should print 4 boolean results");
            assertEquals("true", booleans.get(0), "Valid email should be true");
            assertEquals("false", booleans.get(1), "Invalid email should be false");
            assertEquals("true", booleans.get(2), "Positive number should be true");
            assertEquals("false", booleans.get(3), "Negative number should be false");

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

 */
}
