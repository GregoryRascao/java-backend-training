/**
 * Exercise 5: Delete a Record Safely
 * TODO:
 * 1. Delete a product by ID.
 * 2. Print how many rows were deleted.
 * 3. Add exception handling for invalid IDs.
 */

package jdbc.exercises;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.DatabaseConnection;

public class Exercise5 {
    public static void main(String[] args) {
        int productId = 4;
        String sql = "DELETE FROM products WHERE id = ?";

        if (productId <= 0) {
            System.out.println("Invalid product ID: it must be a positive number.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, productId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 0) {
                System.out.println("No product found with ID " + productId);
            } else {
                System.out.println("Rows deleted: " + rowsDeleted);
            }

        } catch (IOException | SQLException e) {
            System.out.println("Could not delete product: " + e.getMessage());
        }
    }
}
