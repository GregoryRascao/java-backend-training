# Creating Tables and Changing Data

> **Goal:** Understand basic table definitions, database rules, and how to add, change, or remove records.  
> **Prerequisite:** [README1.md](README1.md) and the shared [setup.sql](setup.sql) data.  
> **Important:** We will introduce **DDL vs. DML in README5 next week**. You do not need to learn those categories now.

We have already queried an existing database. Now we will ask: **Who created these tables, and how can information be added or updated?**

## 1. A table needs a structure

Open the [setup.sql](setup.sql) file. It contains this definition for our student table:

```sql
CREATE TABLE lesson_students (
    student_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INT NOT NULL CHECK (age >= 0),
    city VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);
```

**Do not run this block again** if you already ran setup: `lesson_students` already exists.

`CREATE TABLE` defines the table's **structure**. It names the columns, specifies the kinds of values they hold, and declares rules the database should enforce. It does **not** insert any students.

Compare with Java: a class describes what a `Student` object looks like. A table definition describes what data each student row can contain. However, a table does not define Java methods or application behaviour.

## 2. Common SQL data types

| Type | What it holds | Example from our database |
| --- | --- | --- |
| `INT` | Whole numbers | `student_id`, `age` |
| `VARCHAR(100)` | Text up to 100 characters | `full_name`, `city` |
| `NUMERIC(5,2)` | Exact decimals with five total digits, including two after the decimal point | Course grade, such as `87.50` |
| `DATE` | Calendar dates | Enrollment date, such as `'2026-10-01'` |

The type helps PostgreSQL decide which values are valid for a column.

In our course data, we enter student IDs manually. `PRIMARY KEY` does **not** generate a new ID automatically; PostgreSQL has separate features for that.

## 3. Why constraints matter

Suppose two students share the same name, or someone accidentally enters an age of `-4`. The database needs rules beyond simple column types.

| Constraint | Meaning in our lesson |
| --- | --- |
| `PRIMARY KEY` | Identifies each row uniquely and cannot be `NULL` |
| `NOT NULL` | Requires a non-`NULL` value |
| `UNIQUE` | Prevents duplicate values, such as the same email |
| `CHECK` | Requires a condition to be true, such as `age >= 0` |
| `FOREIGN KEY` | Requires a reference to an existing row in another table |

A primary key may consist of more than one column. Our `lesson_enrollments` table uses the pair `(student_id, course_id)` to identify an enrollment. We will explore **foreign keys** and **relationships** in [README3.md](README3.md).

### What is NULL?

`NULL` represents missing or unknown information. It is not zero, and it is not an empty string.

For example, Kien's Spring Boot grade is `NULL` in the shared data because no grade has been recorded yet.

Two subtleties worth remembering:

- `NOT NULL` rejects `NULL` but does not automatically reject the empty string `''`.
- In PostgreSQL, a `UNIQUE` column normally allows multiple `NULL` values. We use `NOT NULL UNIQUE` for email because it must be both present and unique.

## 4. Try creating a small practice table

We will leave the three shared lesson tables alone. Instead, create a **separate practice table**:

```sql
CREATE TABLE lesson_practice_students (
    student_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL
);
```

This is intentionally smaller than our real student table. The new table has **zero rows** until we insert some.

> Run this statement **once**. Running it again will produce an error because a table with that name already exists. If you are repeating the activity in a fresh playground session, check first whether the table exists.

**Think:** Which column should uniquely identify a student? Why is the name alone not sufficient?

## 5. Add students with INSERT

Run these statements in the order shown:

```sql
INSERT INTO lesson_practice_students (student_id, full_name, city)
VALUES (101, 'Alisan', 'Brussels');

INSERT INTO lesson_practice_students (student_id, full_name, city)
VALUES (102, 'Fatma', 'Antwerp');

INSERT INTO lesson_practice_students (student_id, full_name, city)
VALUES (103, 'Nikita', 'Ghent');
```

`INSERT INTO` adds rows to an existing table. The column names and values match **by position**.

Check what was stored:

```sql
SELECT student_id, full_name, city
FROM lesson_practice_students
ORDER BY student_id;
```

You should see three students. We created a structure with `CREATE TABLE`, and then supplied records using `INSERT`.

**Predict:** What happens if you try to insert another student with `student_id = 101`? PostgreSQL rejects that duplicate primary key. You do not need to run the invalid statement.

## 6. Change a record with UPDATE

Imagine Fatma moves to Brussels:

```sql
UPDATE lesson_practice_students
SET city = 'Brussels'
WHERE student_id = 102;
```

`SET` says what should change; `WHERE` selects **which rows** to change.

Verify the result:

```sql
SELECT student_id, full_name, city
FROM lesson_practice_students
WHERE student_id = 102;
```

**Important:** If you leave out `WHERE`, the update will change the city for **every student** in this table. A good habit is to run a `SELECT` with the same condition before changing records.

## 7. Remove a record with DELETE

For the demonstration, remove only Nikita's practice record:

```sql
DELETE FROM lesson_practice_students
WHERE student_id = 103;
```

Now check the table again:

```sql
SELECT *
FROM lesson_practice_students
ORDER BY student_id;
```

Alisan and Fatma remain. The **table itself still exists**; only one row was deleted.

**Safety reminder:** `DELETE` without `WHERE` removes all rows from the target table. Never experiment with this on important data.

## 8. Try the database's rules

Consider these situations before touching the keyboard:

1. Alisan is already student `101`. Can you add another student using ID `101`?
2. Can you insert a practice student without a `full_name` value?
3. Can you store a student's age as `-3` in our shared `lesson_students` table?
4. Would the database allow two different students to have the same name, provided their IDs and emails are different?

The first three are rejected by our table constraints. The fourth is allowed: names are not necessarily unique.

We **do not** need to deliberately cause errors in the playground to understand these rules.

## 9. Where do relationships come in?

Our training application has students, courses, and enrollments. One student can attend more than one course, and one course can have many students.

That is why the shared database contains three connected tables. We will study their relationships, primary and foreign keys, and how `JOIN` uses them in [README3.md](README3.md).

### Who uses SQL?

Backend developers use SQL to retrieve and change application data. Database administrators (DBAs) also work with databases, but focus more on operations such as access, backups, recovery, and availability. These responsibilities can overlap.

## Short exercises

Use **only** `lesson_practice_students` for these tasks:

1. Add `Gregory` with ID `104` and city `Leuven`.
2. Query Gregory's row by ID to verify the insert.
3. Change Gregory's city to `Brussels`.
4. Display all practice students in ID order.
5. Delete Gregory's row by ID.
6. In your own words, explain the difference between `CREATE TABLE`, `INSERT`, `UPDATE`, and `DELETE`.

**Remember:** The names **DDL** and **DML** are intentionally postponed until **README5 next week**. For now, be able to explain what each SQL statement changes.

**Next:** [README2.md — Reading Data with SELECT](README2.md) for deeper filtering, sorting, patterns, missing values, and result handling. Then [README3.md — Relationships and JOINs](README3.md).
