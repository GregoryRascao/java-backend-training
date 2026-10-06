package generics2.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example2ExtendsRead {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        doubles.add(2.2);
        doubles.add(3.3);

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
