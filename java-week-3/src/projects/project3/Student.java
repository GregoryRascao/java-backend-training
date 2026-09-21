package projects.project3;

import java.util.Objects;

public class Student {
    private final String studentId;
    private final String name;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }

        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Deux objets Student representent le meme etudiant si leur identifiant
    // est identique. Cela permet a contains() de detecter les doublons.
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Student other)) {
            return false;
        }
        return studentId.equals(other.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ")";
    }
}
