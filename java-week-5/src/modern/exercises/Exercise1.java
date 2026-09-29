/**
 * 1. Create a method: public static int sum(int... numbers)
 * 2. Return the total of all numbers, or 0 if no arguments are passed.
 * 3. Create a second method: public static double average(int... numbers) that returns the average (0 if no arguments are passed).
 * 4. In main, call sum with 2, 3 and 5 arguments, then print the average for the same calls.
 */

package modern.exercises;

public class Exercise1
{
    public static int sum(int... numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static double average(int... numbers){
        if (numbers.length == 0) {
            return 0;
        }
        return (double) sum(numbers) / numbers.length;
    }
    public static void main(String[] args)
    {
        System.err.println(sum(1,2,3));
        System.out.println(average(1,2,3));
        
    }
}
