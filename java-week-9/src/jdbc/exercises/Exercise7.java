/**
 * TODO:
 * 1. Create a Student class with id, name, age, and email fields.
 * 2. Retrieve all students and map each row to a Student object.
 * 3. Print the students using toString().
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DatabaseConnection;

public class Exercise7 {
    public static void main(String[] args) {
        String sql = "SELECT student_id AS id, full_name AS name, age, email FROM student";
        List<Student> students = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"));
                students.add(student);
            }

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException | SQLException e) {
            System.out.println("Could not retrieve students: " + e.getMessage());
        }
    }

    static class Student {
        private final int id;
        private final String name;
        private final int age;
        private final String email;

        Student(int id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age + " - " + email;
        }
    }
}
