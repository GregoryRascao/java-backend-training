package jdbc.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Example8
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
        String sql = "SELECT id, name, age, email FROM student";
        List<Student> students = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));
            }

            students.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            System.out.println("Could not load students: " + e.getMessage());
        }
    }
}

class Student
{
    private final int id;
    private final String name;
    private final int age;
    private final String email;

    Student(int id, String name, int age, String email)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString()
    {
        return id + " | " + name + " | " + age + " | " + email;
    }
}
