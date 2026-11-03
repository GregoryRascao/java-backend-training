/**
 * Exercise 3: Retrieve Data Using ResultSet
 * TODO:
 * 1. Select all products and print them in this format:
 *    `ID - Name - Price - Category`
 * 2. Only show products where `price > 20`.
 */

package jdbc.exercises;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import jdbc.DatabaseConnection;

public class Exercise3 {
    public static void main(String[] args) {
        String sql = "SELECT id, name, price, category FROM products WHERE price > ?";
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBigDecimal(1, new BigDecimal("20"));

            try (ResultSet resultset = statement.executeQuery()) {
                while (resultset.next()) {
                    System.out.println(resultset.getInt("id") + " - " +
                            resultset.getString("name") + " - " +
                            resultset.getBigDecimal("price") + " - " +
                            resultset.getString("category"));
                }
            }
        } catch (IOException | SQLException e) {
            System.out.println("Could not retrieve products :" + e.getMessage());
        }
    }
}
