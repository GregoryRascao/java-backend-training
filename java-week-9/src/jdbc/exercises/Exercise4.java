/**
 * Exercise 4: Update a Record
 * TODO:
 * 1. Write a program that updates a product’s price.
 * 2. Confirm the update by printing the product again.
 *
 */

package jdbc.exercises;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DatabaseConnection;

public class Exercise4 {
    public static void main(String[] args) {
        String selectQuery = "SELECT * FROM products WHERE id = ?";
        String updateQuery = "UPDATE products SET price = ? WHERE id = ?";
        BigDecimal newPrice = new BigDecimal("4.99");
        int rowsUpdated;

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement uPreparedStatement = connection.prepareStatement(updateQuery)) {
            uPreparedStatement.setBigDecimal(1, newPrice);
            uPreparedStatement.setInt(2, 3);
            rowsUpdated = uPreparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("No product found");
                return;
            }
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setInt(1, 3);
                try (ResultSet resultQuery = selectStatement.executeQuery()) {
                    if (resultQuery.next()) {
                        System.out.println(resultQuery.getInt("id") + " - " + resultQuery.getString("name") + " - " +
                                resultQuery.getBigDecimal("price") + " - " +
                                resultQuery.getString("category"));
                    }
                }
            }

        } catch (IOException | SQLException e) {
            System.out.println("Could not update product: " + e.getMessage());
        }
    }
}
