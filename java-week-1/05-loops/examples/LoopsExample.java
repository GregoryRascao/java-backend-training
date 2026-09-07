/**
 * Loops Example
 * 1- for loop
 * 2- while loop
 * 3- do-while loop
 * 4- for-each loop
 * 5- nested loops
 * 6- break and continue statements
 */


public class LoopsExample
{
    public static void main(String[] args)
    {
        // 1- for loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++)
        {
            System.out.println("Iteration: " + i);
        }

        // 2- while loop
        System.out.println("\nWhile Loop:");
        int j = 1;
        while (j <= 5)
        {
            System.out.println("Iteration: " + j);
            j++;
        }

        // 3- do-while loop
        System.out.println("\nDo-While Loop:");
        int k = 1;
        do
        {
            System.out.println("Iteration: " + k);
            k++;
        } while (k <= 5);

        // 4- for-each loop
        System.out.println("\nFor-Each Loop:");
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits)
        {
            System.out.println("Fruit: " + fruit);
        }

        // 5- nested loops
        System.out.println("\nNested Loops:");
        for (int m = 1; m <= 3; m++)
        {
            for (int n = 1; n <= 2; n++)
            {
                System.out.println("Outer: " + m + ", Inner: " + n);
            }
        }

        // 6- break and continue statements
        System.out.println("\nBreak and Continue:");
        for (int p = 1; p <= 10; p++)
        {
            if (p == 5)
            {
                System.out.println("Breaking at: " + p);
                break; // Exit the loop when p is 5
            }
            if (p % 2 == 0)
            {
                System.out.println("Continuing at even number: " + p);
                continue; // Skip even numbers
            }
            System.out.println("Current number: " + p);
        }
    }
}
