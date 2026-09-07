package arrays.exercises;

/**
 * Exercise 3: Jagged Array
 * TODO:
 * 1. Create a jagged array with 3 rows.
 * 2. Assign values manually.
 * 3. Traverse and print array.
 * 4. Find total number of elements.
 */
public class Exercise3
{
    public static void main(String[] args)
    {
        int[][] jaggedArray = new int[3][];

        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[3];
        jaggedArray[2] = new int[1];
        
        jaggedArray[0][0] = 1;
        jaggedArray[0][1] = 2;

        jaggedArray[1][0] = 3;
        jaggedArray[1][1] = 4;
        jaggedArray[1][2] = 5;

        jaggedArray[2][0] = 6;

        int totalElements = 0;
        for (int row = 0; row < jaggedArray.length; row++) {
            totalElements += jaggedArray[row].length;
        for (int col = 0; col < jaggedArray[row].length; col++) {
            System.out.print(jaggedArray[row][col] + " ");
        }
        System.out.println();
        }
        System.out.println("Total number of elements " + totalElements);
    }
}
