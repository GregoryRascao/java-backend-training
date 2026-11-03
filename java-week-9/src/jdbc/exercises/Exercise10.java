/**
 * TODO:
 * 1. Query a table that does not exist intentionally.
 * 2. Catch SQLException and show a clear, user-friendly message.
 */

package jdbc.exercises;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DatabaseConnection;

public class Exercise10 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM table_not_existing";

        try (Connection connection = DatabaseConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery(sql);
            } catch (SQLException e) {
                IO.println("The query failed. This table may not exist :" + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Could not read the database configuration: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
        }
    }
}
