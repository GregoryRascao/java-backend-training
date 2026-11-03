package statements.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Example4
{
    public static void main(String[] args)
    {
        Properties props = new Properties();
        String filePath = "resources" + File.separator + "config.properties";

        // Load properties
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

        String insert1 = "INSERT INTO student (id, name, age, email) VALUES (102, 'Kien', 22, 'kien@example.com')";
        String insert2 = "INSERT INTO invalid_table (name) VALUES ('ERROR')"; // intentional error

        Connection conn = null;
        Statement stmt = null;

        try
        {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // start transaction
            stmt = conn.createStatement();

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2); // this will fail

            conn.commit();
            System.out.println(" Transaction committed successfully.");

        }
        catch (SQLException e)
        {
            System.out.println(" Error detected: " + e.getMessage());
            try
            {
                if (conn != null)
                {
                    conn.rollback();
                    System.out.println(" Rollback complete.");
                }
            }
            catch (SQLException ex) {
                System.out.println(" Rollback failed: " + ex.getMessage());
            }
        } finally
        {
            // Close resources
            try
            {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

