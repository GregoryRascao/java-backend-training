package projects.project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String name;
    private final Teacher teacher;
    private final List<Student> students = new ArrayList<>();

    public Course(String name, Teacher teacher) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher cannot be null.");
        }

        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void enrollStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException(
                    "This student is already enrolled.");
        }

        students.add(student);
    }

    public void removeStudent(Student student) {
        if (!students.remove(student)) {
            throw new IllegalArgumentException(
                    "This student is not enrolled in the course.");
        }
    }

    // La liste interne ne peut pas etre modifiee depuis l'exterieur.
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void printStudents() {
        System.out.println("Students in " + name + ":");
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }
}
