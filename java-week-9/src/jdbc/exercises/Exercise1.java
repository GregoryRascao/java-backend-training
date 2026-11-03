/**
 * TODO:
 * 1. Use `DriverManager.getConnection()` to connect to your local PostgreSQL database.
 * 2. Print a success or failure message.
 *
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DatabaseConnection;

public class Exercise1 {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (!connection.isClosed()) {
                IO.println("Connection established");
            }
        } catch (IOException | SQLException e) {
            IO.println("Fail To connect :" + e.getMessage());
        }
    }
}
