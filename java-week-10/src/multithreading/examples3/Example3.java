/**
 * Demonstrates combining async computations with CompletableFuture.
 *
 * <p>Key idea: {@link CompletableFuture#supplyAsync} runs a supplier in a
 * background thread. When two futures finish, {@link CompletableFuture#thenCombine}
 * merges their results into a single value. This pattern is useful when two
 * independent tasks can run in parallel but their outputs are needed together.</p>
 */

package multithreading.examples3;

import java.util.concurrent.CompletableFuture;

public class Example3
{
    /**
     * Starts two async tasks and combines their results into one string.
     */
    public static void main(String[] args) throws Exception
    {
        // Simulate a slower async computation.
        CompletableFuture<String> slow = CompletableFuture.supplyAsync(() ->
        {
            try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            return "Data";
        });

        // Start another async computation in parallel.
        CompletableFuture<Integer> value = CompletableFuture.supplyAsync(() -> 42);

        // Combine both results when they are complete.
        CompletableFuture<String> combined = slow.thenCombine(value, (text, num) -> text + "-" + num);
        System.out.println(combined.get());
    }
}
