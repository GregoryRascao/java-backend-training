package testing3.ourexamples.generics.exercises;

/**
 * This file is not yet prepared, still in progress
 *
 * Output-based tests for classes under generics2.projects.
 *
 * The generic helper classes in these files are package-private,
 * so tests verify behavior by running each main method.
 */
public class GenericsProjectsTest {
/*
    public static void main(String[] args) {
        int total = 0;
        int passed = 0;

        total++; if (testProject1MainOutput()) passed++;
        total++; if (testProject2MainOutput()) passed++;
        total++; if (testProject3MainOutput()) passed++;

        System.out.println("Results: " + passed + "/" + total + " tests passed.");
    }

    private static boolean testProject1MainOutput() {
        String testName = "Project1.main output";
        try {
            String output = captureOutput(() -> Project1.main(new String[0]));
            assertContains(output, "[Alice, Bob]", "Project1 should print saved string values");
            assertContains(output, "[10, 20]", "Project1 should print saved integer values");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }


    }

    private static boolean testProject2MainOutput() {
        String testName = "Project2.main output";
        try {
            String output = captureOutput(() -> Project2.main(new String[0]));
            assertContains(output, "28", "Project2 should print Alice age from cache");
            assertContains(output, "Student", "Project2 should print role from second cache");

            System.out.println("PASSED: " + testName);
            return true;
        } catch (AssertionError e) {
            System.out.println("FAILED: " + testName + " - " + e.getMessage());
            return false;
        }
    }

    private static boolean testProject3MainOutput() {
        String testName = "Project3.main output";
        try {
            String output = captureOutput(() -> Project3.main(new String[0]));
            assertContains(output, "Received event: Hello", "Project3 should publish first event");
            assertContains(output, "Received event: Generics are powerful", "Project3 should publish second event");

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

    private static void assertContains(String output, String expectedFragment, String message) {
        if (!output.contains(expectedFragment)) {
            throw new AssertionError(message + " - missing: " + expectedFragment + " in output: " + output);
        }
    }*/
}
