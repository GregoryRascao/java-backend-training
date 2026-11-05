# 🧠 Apache Commons DBCP 2 — Detailed Guide

> **DBCP (Database Connection Pooling)** helps manage and reuse database connections efficiently —
> avoiding the overhead of opening/closing connections for every query.

---

## 📦 1. What Is `commons-dbcp2`?

**Apache Commons DBCP 2** provides a simple and robust **connection pool manager** that works with any
JDBC-compatible database (MySQL, PostgreSQL, Oracle, SQLite, etc.).

Instead of creating and closing new connections each time, DBCP:

* Creates a **pool of pre-initialized connections**.
* Gives you a **ready connection** when needed.
* Returns it to the pool after use — not closing it.
* Reuses it for the next request.

✅ **Benefits**

* Faster performance
* Reduces database load
* Avoids “Too many connections” errors
* Easier resource management

---

## ⚙️ 2. Add the Dependency

If you’re using **Maven**, add this to your `pom.xml`:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-dbcp2</artifactId>
  <version>2.12.0</version>
</dependency>
```

You also need the JDBC driver for your database:

### Example for MySQL

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>9.1.0</version>
</dependency>
```

### Example for PostgreSQL

```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>42.7.3</version>
</dependency>
```

---

## 🧩 3. Basic Usage Example

### ➤ Step 1: Import required classes

```java
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
```

---

### ➤ Step 2: Create and configure the DataSource

A **DataSource** is an object that manages your connection pool.

```java
public class DatabaseConfig 
{
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();

        // JDBC connection settings
        dataSource.setUrl("jdbc:mysql://localhost:3306/movies_db");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Driver
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Pool configuration
        dataSource.setInitialSize(5);   // number of connections created at startup
        dataSource.setMaxTotal(20);     // maximum number of active connections
        dataSource.setMaxIdle(10);      // max idle connections in the pool
        dataSource.setMinIdle(2);       // minimum idle connections
        dataSource.setMaxWaitMillis(10000); // wait time (ms) before giving up
    }

    public static Connection getConnection() throws Exception 
    {
        return dataSource.getConnection();
    }
}
```

---

### ➤ Step 3: Use the Connection

Now you can safely use it in your service or DAO layer:

```java
public class MovieRepository {
    public void listMovies() {
        String query = "SELECT title, year, genre, rating FROM movies";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) 
        {

            while (rs.next()) 
            {
                System.out.printf("🎬 %s (%d) - %s - ⭐ %.1f%n",
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getString("genre"),
                        rs.getDouble("rating"));
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
```

✅ Note:

* The `try-with-resources` statement ensures connections are **automatically returned to the pool**.
* You **don’t close** the pool — just close the `Connection` normally, and DBCP reuses it.

---

## 🧱 4. Example Output

```
🎬 Inception (2010) - Sci-Fi - ⭐ 8.8
🎬 The Godfather (1972) - Crime - ⭐ 9.2
🎬 The Dark Knight (2008) - Action - ⭐ 9.0
```

---

## ⚙️ 5. Configuration Options (Most Useful)

| Method                            | Description                                              |
|-----------------------------------|----------------------------------------------------------|
| `setUrl(String url)`              | JDBC URL of the database                                 |
| `setUsername(String username)`    | Database username                                        |
| `setPassword(String password)`    | Database password                                        |
| `setDriverClassName(String name)` | Fully qualified JDBC driver class                        |
| `setInitialSize(int)`             | Number of connections created on startup                 |
| `setMaxTotal(int)`                | Maximum total connections                                |
| `setMinIdle(int)`                 | Minimum idle connections kept                            |
| `setMaxIdle(int)`                 | Maximum idle connections                                 |
| `setMaxWaitMillis(long)`          | Max wait time for a connection                           |
| `setValidationQuery(String)`      | SQL query to test connection health (e.g., `"SELECT 1"`) |
| `setTestOnBorrow(boolean)`        | Test connection before giving it out                     |
| `setTestWhileIdle(boolean)`       | Periodically test idle connections                       |

### Example health check configuration:

```java
dataSource.setValidationQuery("SELECT 1");
dataSource.setTestOnBorrow(true);
dataSource.setTestWhileIdle(true);
```

---

## 🧩 6. Example for PostgreSQL

```java
dataSource.setUrl("jdbc:postgresql://localhost:5432/movies_db");
dataSource.setUsername("postgres");
dataSource.setPassword("secret");
dataSource.setDriverClassName("org.postgresql.Driver");
```

Everything else works the same.

---

## 🧹 7. Proper Shutdown (Optional)

If your app is long-running (like a Spring Boot or server app), you can close the pool when shutting down:

```java
public static void closeDataSource() 
{
    try 
    {
        dataSource.close();
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}
```

Then call this in your app’s `shutdown hook` or `onExit()` method.

---

## 🧠 8. Common Mistakes & Tips

| Mistake                           | Fix                                                                             |
|-----------------------------------|---------------------------------------------------------------------------------|
| Forgetting JDBC driver dependency | Add the correct driver (MySQL, PostgreSQL, etc.)                                |
| Not closing connections           | Always use `try-with-resources`                                                 |
| Hardcoding credentials            | Move them to a `.properties` file or environment variables                      |
| Connection leaks                  | Don’t store `Connection` objects globally                                       |
| Using wrong driver class          | Check your driver’s documentation (`com.mysql.cj.jdbc.Driver`, not the old one) |

---

## 📜 9. Optional: Load DB Config from a Properties File

You can move credentials to `db.properties` inside `src/main/resources`:

```properties
db.url=jdbc:mysql://localhost:3306/movies_db
db.username=root
db.password=password
db.driver=com.mysql.cj.jdbc.Driver
```

Then load it dynamically:

```java
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig 
{
    private static BasicDataSource dataSource;

    static
    {
        try (InputStream input = DatabaseConfig.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(input);

            dataSource = new BasicDataSource();
            dataSource.setUrl(props.getProperty("db.url"));
            dataSource.setUsername(props.getProperty("db.username"));
            dataSource.setPassword(props.getProperty("db.password"));
            dataSource.setDriverClassName(props.getProperty("db.driver"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
```

This makes your code cleaner and more secure.

---

## 🧩 10. Example Project Structure

```
movie-dbcp-demo/
│
├── pom.xml
├── src/
│   ├── main/java/
│   │   ├── config/
│   │   │   └── DatabaseConfig.java
│   │   └── repository/
│   │       └── MovieRepository.java
│   └── main/resources/
│       └── db.properties
```

---

## ✅ 11. Summary

| Feature             | Description                                 |
|---------------------|---------------------------------------------|
| **Library**         | Apache Commons DBCP 2                       |
| **Purpose**         | Manage reusable JDBC connection pools       |
| **Compatible with** | All JDBC databases                          |
| **Key class**       | `BasicDataSource`                           |
| **Benefit**         | Faster, safer, cleaner database connections |

---

## 💡 12. Final Notes

* Use **DBCP2** in production instead of raw JDBC connections.
* It’s lightweight, widely used, and integrates well with frameworks like **Spring Boot** and **Jakarta EE**.
* In Spring Boot, you don’t even need to configure it manually — Spring uses a DBCP-like pool automatically.

---
https://github.com/sammou00
