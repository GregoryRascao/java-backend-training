/**
 * Demonstrates the ExecutorService + Callable + Future workflow.
 *
 * <p>Key idea: a {@link Callable} represents a task that returns a value.
 * Submitting it to an {@link ExecutorService} gives a {@link Future} that
 * can be used to block, poll, or cancel the task. This example submits a
 * factorial calculation, waits for completion with {@code get()}, prints
 * the result, then shuts the executor down to release resources.</p>
 */

package multithreading.examples2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example2
{
    /**
     * Runs a background factorial computation and reads the result via Future.
     */
    public static void main(String[] args) throws Exception
    {
        // Create a single-thread executor to run tasks in the background.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Callable returns a value when the task finishes.
        Callable<Integer> factorial = () ->
        {
            int result = 1;
            for (int i = 2; i <= 5; i++)
            {
                result *= i;
            }
            return result;
        };

        // Submit the task and block until the result is available.
        Future<Integer> future = executor.submit(factorial);
        System.out.println("Factorial: " + future.get());

        // Shut down the executor to release resources.
        executor.shutdown();
    }
}
