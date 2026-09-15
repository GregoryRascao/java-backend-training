package arraylist.exercises;

import java.util.ArrayList;

/**
 * Exercise 5: Print Every Element
 * TODO:
 * 1. Create an ArrayList with five city names.
 * 2. Print every city with an enhanced for loop.
 * 3. Print every city again with a regular for loop and get().
 */
public class Exercise4
{
    public static void main(String[] args)
    {
        // TODO: Implement the exercise.
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brussels");
        cities.add("Lisbon");
        cities.add("Paris");
        cities.add("Abidjan");
        cities.add("London");

        System.out.println("---------------For LOOP-------------");
        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("---------------REGULAR For LOOP-------------");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
    }
}