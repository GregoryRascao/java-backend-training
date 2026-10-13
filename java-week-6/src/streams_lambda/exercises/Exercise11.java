/**
 * BinaryOperator vs BiFunction Practice
 *
 * 1. Create a BiFunction<Integer, Integer, Integer> for addition.
 * 2. Create a BinaryOperator<Integer> for addition.
 * 3. Apply both to the same values and print both results.
 * 4. Use BinaryOperator<Integer> inside reduce(...) to sum a list of integers.
 * 5. Add a short comment: when should BinaryOperator be preferred over BiFunction?
 */

package streams_lambda.exercises;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Exercise11
{
    public static void main(String[] args)
    {
        // * 1. Create a BiFunction<Integer, Integer, Integer> for addition.
        BiFunction<Integer, Integer, Integer> addMethod = (a,b) -> a +b;
        
        // * 2. Create a BinaryOperator<Integer> for addition.
        BinaryOperator<Integer> addMethod2 = (a, b) -> a + b;

        // * 3. Apply both to the same values and print both results.
        System.out.println("Version A :" + addMethod.apply(2,4));
        System.out.println("Version B :" + addMethod2.apply(2, 6));

        // * 4. Use BinaryOperator<Integer> inside reduce(...) to sum a list of integers.
        List<Integer> addMethod3 = List.of(1, 2, 3);
        int sumFinal = addMethod3.stream().reduce(0, addMethod2);
        System.out.println("Version sum total " + sumFinal);
    }
}
