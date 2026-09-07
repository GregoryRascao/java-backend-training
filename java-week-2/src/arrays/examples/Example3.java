package arrays.examples;

/**
 * Example 3: Jagged Arrays : Arrays with Varying Row Lengths
 * ------------------------------------------------------------
 * This example demonstrates how to create and work with jagged arrays in Java, where each row
 * can have a different length.
 */
public class Example3
{
    public static void main(String[] args)
    {
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{3, 4, 5};
        jagged[2] = new int[]{6};

        for (int i = 0; i < jagged.length; i++)
        {
            for (int j = 0; j < jagged[i].length; j++)
            {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
