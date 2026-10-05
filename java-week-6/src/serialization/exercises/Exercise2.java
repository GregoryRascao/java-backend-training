/**
 * 1. Create a Student class (name, grade) that implements Serializable.
 * 2. Create a list of students and serialize it to "students.ser".
 * 3. Deserialize it and print all names and grades.
 */

package serialization.exercises;

import java.io.*;
import java.util.*;

public class Exercise2 {
    static class Student implements Serializable {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Student " + name + ", " + " grade= " + grade;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlotte", 18.5));
        students.add(new Student("Gayatri", 18.9));
        students.add(new Student("Grégory", 16.2));

        String fileName = "Student.ser";

        // serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
            System.out.println("Student saved to " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Désérialisation
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Student> loadedStudents = (List<Student>) in.readObject();

            for (Student s : loadedStudents) {
                System.out.println(s.getName() + " - " + s.getGrade());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}