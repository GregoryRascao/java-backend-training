package iterators.exercises;


import java.util.*;

/**
 * 1. Create a List<Integer> grades with values (55, 70, 90, 45, 82, 100, 60).
 * 2. Use an Iterator to remove all grades below 60.
 * 3. Calculate the average of the remaining grades using a for-each loop.
 * 4. Print both the filtered list and the average grade.
 */
public class Exercise4 {
    static void main(String[] args) {
        List<Integer> grades = new ArrayList<>(Arrays.asList(55, 70, 90, 45, 82, 100, 60));

        Iterator<Integer> it = grades.iterator();
        it.next();

        System.out.println("Before " + grades);

        while (it.hasNext()) {
            int grade = it.next();
            if(grade <= 60){
                it.remove();
            }
        }
        System.out.println("After " + grades);

        int sum = 0;
        for(Integer grade : grades){
            sum += grade;
        }
        double average = grades.isEmpty() ? 0 : (double) sum / grades.size();
        System.out.print("Average " + average);
    }
}
