package collections.exercises;

import java.util.List;
import java.util.Set;

/**
 * 1. Create a Set<String> cities.
 * 2. Add at least 5 city names, including one duplicate.
 * 3. Print all cities (verify no duplicates).
 * 4. Check if a given city exists.
 */

public class Exercise2 {
    public static void main(String[] args) {
        Set<String> cities = new HashSet<>();

        cities.add("Paris");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("New York");
        cities.add("Berlin");

        cities.add("Paris");
        System.out.println("All cities :" + cities);

        if(cities.contains("Tokyo")){
            System.out.println("Tokyo exist");
        } else{
            System.out.println("Nope !!");
        }
    }
}
