
## CRUD Operations with JDBC

CRUD stands for the four basic operations an application performs on stored data:

| Operation | SQL command | Purpose |
| --- | --- | --- |
| Create | `INSERT` | Add a row |
| Read | `SELECT` | Retrieve rows |
| Update | `UPDATE` | Change existing rows |
| Delete | `DELETE` | Remove rows |

For example, a student table might be defined as:

```sql
CREATE TABLE students (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INTEGER,
    email VARCHAR(255)
);
```

Use `PreparedStatement` for values supplied by users or the application:

```java
String sql = "UPDATE student SET email = ? WHERE id = ?";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, "new_email@example.com");
    ps.setInt(2, 1);

    int rowsUpdated = ps.executeUpdate();
    System.out.println("Rows updated: " + rowsUpdated);
}
```

`executeUpdate()` returns the number of affected rows for `INSERT`, `UPDATE`, and `DELETE`. For a `SELECT`, use `executeQuery()` and iterate through the returned `ResultSet` with `rs.next()`. Prefer selecting the columns you need instead of `SELECT *`.

### Mapping database rows to Java objects

Applications often convert each result row into an object. This is a manual form of object-relational mapping:

```java
List<Student> students = new ArrayList<>();
while (rs.next()) {
    students.add(new Student(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getInt("age"),
        rs.getString("email")
    ));
}
students.forEach(System.out::println);
```

See [Example8](examples/Example8.java) for a complete example.
For inserting rows with database-generated IDs, see [README2.md](README2.md).

## Transactions

A transaction groups related database operations so that they succeed or fail as one unit. By default, JDBC connections use auto-commit, so each statement is committed separately. Disable it when multiple statements must be treated as one operation:

```java
conn.setAutoCommit(false);
try {
    // Execute all related statements using this connection.
    conn.commit();
} catch (SQLException e) {
    conn.rollback();
    throw e;
}
```

Call `commit()` only after all operations succeed. If an operation fails, call `rollback()` so earlier changes in the transaction are not left partially applied. Use try-with-resources to close JDBC resources. See [Example9](examples/Example9.java) and [Example10](examples/Example10.java) for commit and rollback examples.

### Note
Auto-commit is a setting on a JDBC connection. Changing it affects that connection, not future connections. If you keep using the same connection after a transaction, restore auto-commit when appropriate; a newly opened connection starts with the driver's default setting (typically `true`). See [Exercise13](exercises/Exercise13.java) to explore this behavior.

## Learning outcomes

* Perform CRUD operations and map database rows to Java objects
* Use `PreparedStatement` for parameterized queries
* Handle database errors and manage transactions with commit and rollback