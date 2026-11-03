/**
 * Exercise 3 — Query a Student by ID
 * TODO:
 * 1. Write a program that prompts the user for a student ID.
 * 2. Use a `PreparedStatement` to fetch the student record.
 * 3. Print their name and email if found, otherwise print “Student not found.”
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.DatabaseConnection;

public class Exercise6 {
    public static void main(String[] args) {
        String sql = "SELECT full_name as name, email FROM student WHERE student_id = ?";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter student ID: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid numeric ID.");
                return;
            }

            int studentId = scanner.nextInt();

            try (Connection connection = DatabaseConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, studentId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Name: " + resultSet.getString("name"));
                        System.out.println("Email: " + resultSet.getString("email"));
                    } else {
                        System.out.println("Student not found.");
                    }
                }
            }
        } catch (IOException | SQLException e) {
            System.out.println("Could not retrieve student: " + e.getMessage());
        }
    }
}
