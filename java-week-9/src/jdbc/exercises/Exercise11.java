/**
 * TODO:
 * 1. Disable auto-commit.
 * 2. Insert two students in one transaction using PreparedStatement.
 * 3. Commit if both inserts succeed.
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.DatabaseConnection;

public class Exercise11 {
    public static void main(String[] args) {
        String sql = "INSERT INTO student (student_id, full_name, age, city, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 10);
                statement.setString(2, "Demo Student One");
                statement.setInt(3, 22);
                statement.setString(4, "Brussels");
                statement.setString(5, "demo1@example.com");
                statement.executeUpdate();

                statement.setInt(1, 11);
                statement.setString(2, "Demo Student Two");
                statement.setInt(3, 24);
                statement.setString(4, "Antwerp");
                statement.setString(5, "demo2@example.com");
                statement.executeUpdate();

                connection.commit();
                System.out.println("Both students were inserted.");
            } catch (SQLException e) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back.");
                } catch (SQLException rollbackError) {
                    e.addSuppressed(rollbackError);
                }
                System.out.println("Could not insert students: " + e.getMessage());
            }
        } catch (IOException | SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
        }
    }
}
