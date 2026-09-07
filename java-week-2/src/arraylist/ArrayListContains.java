package arraylist;

import java.util.*;

public class ArrayListContains {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Fruits: " + fruits);

        fruits.set(1, "Mango");
        System.out.println("After update: " + fruits);

        fruits.remove("Apple");
        System.out.println("After removal: " + fruits);

        System.out.println("Contains Cherry? " + fruits.contains("Cherry"));
        System.out.println("Size: " + fruits.size());
    }
}