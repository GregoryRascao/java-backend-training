package jdbc.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Example10
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
        String insertStudent = "INSERT INTO student (name, age, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            conn.setAutoCommit(false);

            try (PreparedStatement insert = conn.prepareStatement(insertStudent);
                 PreparedStatement invalidInsert = conn.prepareStatement(
                         "INSERT INTO table_that_does_not_exist (name) VALUES (?)"))
            {
                insert.setString(1, "Kien");
                insert.setInt(2, 22);
                insert.setString(3, "kien@example.com");
                insert.executeUpdate();

                invalidInsert.setString(1, "This statement is expected to fail");
                invalidInsert.executeUpdate();

                conn.commit();
            }
            catch (SQLException e)
            {
                rollback(conn, e);
                System.out.println("Transaction failed as expected: " + e.getMessage());
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void rollback(Connection conn, SQLException cause)
    {
        try
        {
            conn.rollback();
            System.out.println("Rollback complete.");
        }
        catch (SQLException rollbackError)
        {
            System.err.println("Rollback failed: " + rollbackError.getMessage());
            cause.addSuppressed(rollbackError);
        }
    }
}
