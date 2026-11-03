/**
 * TODO:
 * 1. Create a simple login simulation using a demo accounts table.
 * 2. Prompt for a username and password.
 * 3. Use a PreparedStatement to check for a matching account.
 * 4. Print whether the credentials match.
 * Do not use real credentials or store plain-text passwords in a real application.
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.DatabaseConnection;

// CREATE TABLE demo_accounts (
//     id SERIAL PRIMARY KEY,
//     username VARCHAR(50) UNIQUE NOT NULL,
//     account_password VARCHAR(100) NOT NULL
// );

// INSERT INTO demo_accounts (username, account_password)
// VALUES ('demo', 'demo123');

public class Exercise9 {
    public static void main(String[] args) {
        String sql = """
                SELECT 1
                FROM demo_accounts
                WHERE username = ? AND account_password = ?
                """;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            try (Connection connection = DatabaseConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, username);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Credentials match.");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                }
            }
        } catch (IOException | SQLException e) {
            System.out.println("Could not check credentials: " + e.getMessage());
        }
    }
}
