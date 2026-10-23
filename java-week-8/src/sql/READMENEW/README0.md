# Before SQL: Why Do We Need Databases?

We need to understand what problem databases solve before learning SQL syntax.  

## 1. We already know how to store data in Java

Imagine we are building a small training application. It needs to remember students, their courses, and their grades.

In Java, we might start with objects and a list:

```java
class Student {
    int id;
    String name;
    String city;
}

List<Student> students = new ArrayList<>();
```

We could add `Ulpan`, `Samira`, and `Nikita` to this list. This works while the application is running. But what happens when we stop the program?

The list exists in memory. Its contents are not automatically saved for the next run.

**Think:** We restart our training application tomorrow. Where should the students' information come from?

## 2. Why not just use a file?

We already know how to write information to a file and read it back. Files are useful, and many applications use them.

But imagine that our application grows:

- We have 1,000 students and want to find those living in Brussels.
- Mila changes her email address. We need to update the correct record.
- Two staff members edit student information around the same time.
- We must make sure two students are not accidentally assigned the same student ID.
- We need to find which students attend a particular course.

We *can* write code to handle some of these problems with files. However, we would have to build and maintain much of the searching, updating, consistency, and concurrent-access logic ourselves.

A **database management system** already provides tools for these tasks.

| Working with Java collections/files | Working with a database |
| --- | --- |
| Collections primarily hold data in application memory | Data can remain stored between application runs |
| File reading and updating logic is our responsibility | We can ask the database to find and update specific records |
| We enforce many data rules in our Java code | The database can enforce rules such as unique IDs |
| Supporting simultaneous changes needs additional design | Database systems provide concurrency and transaction mechanisms |

This does **not** mean databases replace Java collections or files. We use each where it makes sense.

## 3. Database vs. DBMS

A **database** is an organized collection of stored data.

A **database management system (DBMS)** is software that manages that data and provides ways to access and protect it.

In this course, we use **PostgreSQL**, a relational DBMS. Other examples include MySQL and SQLite.

A useful distinction:

- **Database:** the stored information about our students and courses.
- **PostgreSQL:** the system that stores, manages, and retrieves that information.
- **SQL:** the language we use to ask the database system to work with that information.

## 4. How does a Java application use a database?

A simplified picture looks like this:

```text
User
  |
  v
Java application
  |
  |  JDBC (Java database access API)
  v
PostgreSQL (DBMS)
  |
  v
Database: students, courses, enrollments
```

For example, when a user asks to see all students in Brussels:

1. The Java application receives the request.
2. It sends a database query through a database connection.
3. PostgreSQL finds the matching rows.
4. Java receives the results and decides what to display.

**We will write SQL ourselves first.** Connecting Java to PostgreSQL with JDBC comes later. Spring Boot will build on this knowledge.

## 5. What is a relational database?

A relational database organizes data into **tables**. Think of a table as a structured collection of records. It resembles a spreadsheet, but a database also supports constraints, relationships, and queries.

Here is an **illustrative** student table (not the data loaded by our lesson setup script):

| student_id | name | city |
| --- | --- | --- |
| 1 | Ulpan | Brussels |
| 2 | Mila | Antwerp |
| 3 | Samira | Brussels |

- A **table** represents one kind of information (students).
- A **column** describes one property (`name` or `city`).
- A **row** represents one student record.
- An **ID** helps us identify a particular record, even when names are identical.

Our training application also needs courses. We could have a `courses` table and an `enrollments` table that records which students attend which courses. We will explore these relationships in a later lesson.

**Compare with Java:** a `Student` object may represent one student, just as a database row does. But a database table is **not** a Java class: it stores values and rules, not Java methods.

## 6. What is SQL?

**SQL (Structured Query Language)** lets us communicate with relational databases. With SQL, we can ask questions such as:

- Which students live in Brussels?
- Which courses does Paul attend?
- How many students are enrolled?

We can also use SQL to create tables and change stored information.

SQL is largely **declarative**: we describe the result we want, instead of writing a Java loop that manually searches every record.

Here is a preview of a query — **you do not need to understand its syntax yet**:

```sql
SELECT full_name
FROM student;
```

Read it as: “Show the full names from the students table.”

> **Coming next week (README5):** We will learn the difference between **DDL** and **DML**, and how SQL commands are categorized. For now, focus on what each command actually does.

## 7. The tools we will use

| Tool | Purpose |
| --- | --- |
| **PostgreSQL** | Database management system that runs our SQL |
| **SQL Tutorial Playground** | Browser-based place to practice SQL |
| **pgAdmin** | Graphical tool for managing PostgreSQL; used later |
| **psql** | Terminal-based PostgreSQL client; optional for now |
| **JDBC** | Java API to access databases; used later |

Start with the [SQL Tutorial Playground](https://www.sqltutorial.org/playground/). We do **not** need to install PostgreSQL or pgAdmin to begin this lesson. Data is provided there.

## Check your understanding

Before moving on, discuss these questions:

1. Why might an `ArrayList<Student>` be insufficient for an application that must remember students after restarting?
2. Could we store student records in a file? What extra problems might appear as the application grows?
3. What is the difference between a database, PostgreSQL, and SQL?
4. In a student table, what is the difference between a row and a column?
5. Does a database remove the need for Java objects? Why or why not?

**Next:** [README1.md — Your First SQL Queries](README1.md). We will read existing data before creating any tables.
