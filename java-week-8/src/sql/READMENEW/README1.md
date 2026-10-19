# Your First SQL Queries: Read the Data First

> **Goal:** Run your first queries against an existing database.  
> **You will use:** `SELECT`, `FROM`, a simple `WHERE`, and `ORDER BY`.  
> **Not yet:** Creating tables, changing stored rows, or connecting from Java.  
> **Coming next week:** We will explain the **DDL** and **DML** categories in README5.

In [README0.md](README0.md), we learned why databases exist. Now let's use one.

## 1. Open the SQL playground

Go to [SQL Tutorial Playground](https://www.sqltutorial.org/playground/).

The page provides a SQL editor, a **Run** action, and a result area. We will use it to practice queries without installing PostgreSQL or pgAdmin on our computers.

### Prepare our shared lesson database

For consistency, everyone will work with the same three tables:

| Table | Contains |
| --- | --- |
| `lesson_students` | Student details |
| `lesson_courses` | Courses such as Java and SQL |
| `lesson_enrollments` | Which students attend which courses |

**Setup (once at the start):**

1. Open [setup.sql](setup.sql) from the course repository.
2. Copy its contents into the playground editor and click **Run**.
3. Check that the sample student records appear in the result.
4. Replace the setup script in the editor with the first query below.

Students can also run the setup script if they need their own copy of the lesson data. **You do not need to understand the setup script yet.** It prepares the tables so we can learn by querying them.

**Important:** Running `setup.sql` again **deletes and recreates these three lesson tables**. It is a reset, not something to run before every query. Save any SQL you want to keep outside the playground.

The `lesson_` prefix distinguishes our tables from any example tables already shown by the website.

## 2. Ask the database a question

Run this query:

```sql
SELECT full_name
FROM lesson_students;
```

**“From the students table, show the full_name column.”**

The result should contain five rows. Look at the values in the result area.

We did not write a Java `for` loop. We told PostgreSQL what data we wanted, and it returned the result.

**Discuss:** Did this query change or delete any student records?

## 3. Select multiple columns

```sql
SELECT student_id, full_name, city
FROM lesson_students
ORDER BY student_id;
```

Expected result after setup:

| student_id | full_name | city |
| --- | --- | --- |
| 1 | Kien Ahmed | Brussels |
| 2 | Malek Janssen | Antwerp |
| 3 | Ulpan Peeters | Brussels |
| 4 | Paul Janssens | Ghent |
| 5 | Gayatri Yilmaz | Brussels |

What changed? The database still stores the same student records, but the result now displays three columns.

You can also request every column:

```sql
SELECT *
FROM lesson_students
ORDER BY student_id;
```

`*` means **all columns**. It is convenient for inspecting a small table. In an application, requesting only the columns you actually need is usually clearer and avoids fetching unnecessary data.

## 4. Filter rows with WHERE

Imagine we want only students from Brussels:

```sql
SELECT full_name, city
FROM lesson_students
WHERE city = 'Brussels'
ORDER BY student_id;
```

This returns **Kien Ahmed, Ulpan Peeters, and Gayatri Yilmaz**.

`WHERE` chooses **which rows** match a condition. `SELECT` chooses **which columns** appear in the result. These are different operations.

Notice the syntax:

- SQL uses `=` to compare values. In Java, we often use `==` for primitive equality.
- Text values go in **single quotes**, such as `'Brussels'`.
- SQL keywords are written in uppercase here for readability; this is a style convention.
- A semicolon `;` ends the statement.

Try changing the city to `'Ghent'`. What name do you expect to see?

## 5. Choose a predictable order

```sql
SELECT full_name, age
FROM lesson_students
ORDER BY age DESC, student_id ASC;
```

`ORDER BY` sorts the **result**. `DESC` means descending; `ASC` means ascending. The second column breaks ties between students of the same age.

Without `ORDER BY`, the database does **not** guarantee a particular row order, even if the result appears ordered today.

> We will study sorting, filtering operators, patterns, missing values, and limiting results in more detail in [README2.md](README2.md). Today is just a first look.

## 6. A query does not change the stored table

A SQL query can return fewer columns, fewer rows, or rows in a different order. That does not mean the underlying table was edited.

For example:

```sql
SELECT full_name
FROM lesson_students
WHERE student_id = 3;
```

This displays **Ulpan Peeters**. It does not remove the other four students from the database.

Think of the result as a *view of the data produced by this query*, not a replacement for the stored table.

## 7. A connection to Java Streams

You already know how to filter data in Java:

```java
List<Student> brusselsStudents = students.stream()
        .filter(s -> s.getCity().equals("Brussels"))
        .toList();
```

In SQL, a similar question can be written as:

```sql
SELECT full_name, city
FROM lesson_students
WHERE city = 'Brussels';
```

Both express a filtering idea, but there is an important difference: **Java Streams operate on data available to the Java program; SQL asks the database to produce a result from stored data.** Later, we will connect these worlds with JDBC.

## Short exercises

**Predict the result first; then run the query.**

1. Show the `full_name` and `email` of every student.
2. Show only the record with `student_id = 4`. Which student is it?
3. Show the names and cities of students from Brussels.
4. Show every student's name and age, ordered from youngest to oldest.
5. Explain why `SELECT full_name FROM lesson_students;` does not erase the other columns.

### Before moving on

You should be able to explain **table**, **row**, **column**, **query**, **result**, `SELECT`, and `WHERE` in your own words.

**Next:** [README1B.md — Create Tables and Change Data](README1B.md). We will learn how the data we just queried gets stored in the first place.
