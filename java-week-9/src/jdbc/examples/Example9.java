package jdbc.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Example9
{
    public static void main(String[] args)
    {
        Properties props = new Properties();
        String filePath = "resources" + File.separator + "config.properties";
        try (FileInputStream fis = new FileInputStream(filePath))
        {
            props.load(fis);
        }
        catch (IOException e)
        {
            System.out.println("Could not read config file: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String sql = "INSERT INTO student (name, age, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setString(1, "Maya");
                ps.setInt(2, 21);
                ps.setString(3, "maya@example.com");
                ps.executeUpdate();

                ps.setString(1, "Omar");
                ps.setInt(2, 23);
                ps.setString(3, "omar@example.com");
                ps.executeUpdate();

                conn.commit();
                System.out.println("Transaction committed successfully.");
            }
            catch (SQLException e)
            {
                rollback(conn, e);
                throw e;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    private static void rollback(Connection conn, SQLException cause)
    {
        try
        {
            conn.rollback();
            System.out.println("Transaction rolled back.");
        }
        catch (SQLException rollbackError)
        {
            System.err.println("Rollback failed: " + rollbackError.getMessage());
            cause.addSuppressed(rollbackError);
        }
    }
}
