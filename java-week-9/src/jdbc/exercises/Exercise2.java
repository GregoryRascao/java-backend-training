/**
 * Exercise 2: Insert Multiple Records
 * TODO:
 * 1. Create a `products` table with columns `id`, `name`, `price`, and `category`.
 * 2. Write a Java program to insert 3 new products using SQL `INSERT`.
 */

package jdbc.exercises;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.DatabaseConnection;

public class Exercise2 {
    public static void main(String[] args) {
        String sql = "INSERT INTO products (name, price, category) VALUES (?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Monitor");
            statement.setBigDecimal(2, new BigDecimal("49.99"));
            statement.setString(3, "Electronics");
            statement.addBatch();

            int[] results = statement.executeBatch();
            System.out.println("Products inserted: " + results.length);

        } catch (IOException | SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
}
