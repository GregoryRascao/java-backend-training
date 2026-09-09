package collections.exercises;

import java.util.*;

/**
 TODO:
 1. Create a Map<String, List<Integer>> grades.
    - Key = student name
    - Value = list of grades
 2. Add at least 3 students with multiple grades each.
 3. Print all students with their grades.
 4. Calculate and print the average grade for each student.
*/
public class Exercise4 {
    public static void main(String[] args) {
        Map<String, List<Integer>> myMap = new HashMap();
        myMap.put("Jonathan", Arrays.asList(4,5,6) );               //immutable
        myMap.put("Julie", new ArrayList<>(Arrays.asList(7,8,9)) ); //mutable


    }
}
