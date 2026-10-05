package generics2.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example4Pecs {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1,2,3);
        List<Number> numbers = new ArrayList<>();

        copyElements(ints, numbers);

        System.out.println(numbers);
    }

    public static <T> void copyElements(
            List<? extends T> source,
            List<? super T> destination) {

        for(T item : source) {
            destination.add(item);
        }
    }
}