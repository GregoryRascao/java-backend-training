package collections.exercises;

import java.lang.reflect.Array;
import java.util.*;

/**
 * TODO:
 * 1. Create a Map<String, List<Integer>> grades.
 * - Key = student name
 * - Value = list of grades
 * 2. Add at least 3 students with multiple grades each.
 * 3. Print all students with their grades.
 * 4. Calculate and print the average grade for each student.
 */
public class Exercise4 {
    public static void main(String[] args) {
        Map<String, List<Integer>> grades = new HashMap<>();

        // grades.put("Paul", new ArrayList<>(Arrays.asList(4, 5, 6)));
        // grades.put("Charlotte", new ArrayList<>(Arrays.asList(7, 8, 9)));
        // grades.put("Greg", new ArrayList<>(Arrays.asList(10, 12, 14)));

        grades.put("Gregory", Arrays.asList(70, 80, 90));
        grades.put("Chitra", Arrays.asList(70, 80, 90));
        grades.put("Paul", Arrays.asList(70, 80, 90));

        for (Map.Entry<String, List<Integer>> entry : grades.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> studentGrades = entry.getValue();

            int total = 0;

            for (int grade : studentGrades) {
                total += grade;
            }

            double average = (double) total / studentGrades.size();

            System.out.println(studentName + " : " + studentGrades);
            System.out.println("Moyenne : " + average);
        }

    }

    public static void printGrades(Map<String, List<Integer>> grades) {
        for (Map.Entry<String, List<Integer>> student : grades.entrySet()) {
            System.out.println(student.getKey() + " has notes " + student.getValue());
        }
    }

    public static void getGrades(Map<String, List<Integer>> grades) {
        String explanation = "";
        for (String person :  grades.keySet() ) {
            explanation = explanation + person + " has notes " + grades.get(person) + " points " +  System.lineSeparator();
        }
    }

}
