package iterators.examples;

import java.util.*;

public class Example3 {
    //This doesn't work without iterator
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>(
                Arrays.asList("Dog", "Cat", "Deer", "Lion")
        );

        for (String animal : animals) {
            if (animal.startsWith("D")) {
                animals.remove(animal); //  WRONG
            }
        }

        System.out.println(animals);
    }
}