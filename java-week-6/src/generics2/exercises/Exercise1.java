package generics2.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 1: Wildcards and PECS
 *
 * Tasks:
 * 1. Write printList(List<?> list) and print all items.
 * 2. Write sumNumbers(List<? extends Number> numbers) and return the total.
 * 3. Write addDefaults(List<? super Integer> list) that adds 1, 2, 3.
 * 4. Write copy(List<? extends T> source, List<? super T> destination).
 * 5. In main(), test all methods using Integer, Double, Number, and Object lists.
 */
public class Exercise1 {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(2.5, 3.5);
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        // call your methods here
        printList(ints);
        printList(doubles);

        sumNumbers(ints);
        sumNumbers(doubles);

        addDefaults(numList);
        addDefaults(objList);

        printList(numList);
        printList(objList);
    }

    // task 1
    public static void printList(List<?> list){
        for (Object item : list) {
            System.out.println(item);
        }
    }


    // task 2
    public static double sumNumbers(List<? extends Number> numbers){
        double total = 0.0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }


    // task 3
    public static void addDefaults(List<? super Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
    }


    // task 4
    public static <T> void copy(List<? extends T> source, List<? super T> destination ){
        for (T t : source) {
            destination.add(t);
        }
    }
}
