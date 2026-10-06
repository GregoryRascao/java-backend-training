package generics2.examples;

import java.util.ArrayList;
import java.util.List;

public class Example3SuperWrite {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addDefaults(ints);
        addDefaults(numbers);
        addDefaults(objects);

        System.out.println(ints);
        System.out.println(numbers);
        System.out.println(objects);
    }

    public static void addDefaults(List<? super Integer> values) {
        System.out.println(values.get(0));  //object
        values.add(10);
        values.add(20);
        values.add(30);
    }
}