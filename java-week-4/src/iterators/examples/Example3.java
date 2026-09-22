package iterators.examples;

import java.util.*;

public class Example3 {
    //This doesn't work without iterator
    public static void main(String[] args) {
        //Arrays.asList creates a fixed-size array, so add or remove is not allowed but you can update
        List<String> animals = new ArrayList<>(Arrays.asList("Dog", "Cat", "Deer", "Lion", "Giraffe", "Zebra") );


        animals.set(0, "Bird");      //Arrays.asList is FIXED SIZE not Immutable!
                                        //go to week2 arraylist.md
        animals.remove(0);      //TODO explain how this works on stack and heap

        for (String animal : animals) {
            if (animal.startsWith("D")) {
                animals.remove(animal); //  WRONG behaviour
            }
            System.out.println(animal); //cannot be trusted!
        }
        // this WORKED but not to be trusted, add giraffe and zebra!
        //
        System.out.println(animals);
    }
}