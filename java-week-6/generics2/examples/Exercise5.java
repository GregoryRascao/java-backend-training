package generics2.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        //printList(ints);
    }

    public static <T> void printList(List<T> list, T t)
    {
        list.add(null);
        for (Object item : list) {
            System.out.println(item);
        }
        Object o = new Object();
//        list.add(o);  //not allowed
        // ?  is when we dont care about the type
        // because we won't do anything that would break it
        list.add(t);
    }

    public static double sumNumbers(List<? extends Number> numbers)
    {
        double sum = 0;

        for (Number n : numbers)
        {
            sum += n.doubleValue();
        }
        //numbers.add(Integer.valueOf(1)); /not allowed bc it might have been a list of Double's
        return sum;
    }

    public static void addDefaults(List<? super Integer> values)
    {
        values.add(10);
        values.add(20);
        //Serializable object = values.get(0);
    }
}
