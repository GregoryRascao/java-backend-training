package interfaces.exercises;

/**
 * Exercise 1:
 * Create a Student class with name and grade.
 * Implement Comparable<Student> so that students are sorted by grade.
 * In main(), add some students to a List and sort them using Collections.sort().
 * Print the sorted list.
 * Note : Comparable<T> interface (built-in in Java).
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//type parameter
//generic type
    //Generics allow us to specify the type a class works with.
class Student implements Comparable<Student> {  //This Comparable works with Student objects.
//    The angle brackets tell Java what type we are comparing.
    //Student objects can be compared with other Student objects.
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        // Ascending order by grade
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return name + " - " + grade;
    }
}

public class Exercise1 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 70));
        students.add(new Student("Charlie", 95));
        students.add(new Student("Diana", 60));

        Collections.sort(students);

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
