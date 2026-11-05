/**
 * Runtime memory example.
 */

package multithreading.examples3;

public class Example4
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();

        long usedBefore = runtime.totalMemory() - runtime.freeMemory();
        int[] data = new int[5_000_000];
        data[0] = 1;

        long usedAfter = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Used before: " + (usedBefore / (1024 * 1024)) + " MB");
        System.out.println("Used after: " + (usedAfter / (1024 * 1024)) + " MB");
    }
}
