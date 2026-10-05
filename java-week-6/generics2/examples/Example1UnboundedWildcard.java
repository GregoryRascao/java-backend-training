package generics2.examples;

import java.util.List;

public class Example1UnboundedWildcard {

    public static void main(String[] args) {

        List<String> words = List.of("A", "B", "C");
        List<Integer> numbers = List.of(1, 2, 3);

        printList(words);
        printList(numbers);
    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}