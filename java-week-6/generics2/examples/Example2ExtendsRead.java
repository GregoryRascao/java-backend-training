package generics2.examples;

import java.util.Arrays;
import java.util.List;

public class Example2ExtendsRead {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1,2,3);
        List<Double> doubles = Arrays.asList(1.5,  2.5);

        System.out.println(sumNumbers(ints));
        System.out.println(sumNumbers(doubles));
    }

    public static double sumNumbers(List<? extends Number> numbers) {

        double sum = 0;

        for(Number n : numbers) {
            sum += n.doubleValue();
        }

        return sum;
    }
}

// Why can't we do numbers.add(10)?
