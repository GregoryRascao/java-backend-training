# Advanced SQL Concepts (Deeper Understanding)

This section explains how databases work internally and how they are used safely in real-world systems.

Topics:
- ACID properties (with concurrency example)
- Locking: optimistic vs pessimistic
- DDL vs DML
- Primary keys, indexing, and storage
- How databases store data (B+ Trees)
- Users, roles, and permissions
- SQL dialects (T-SQL, PL/SQL)
- SQL injection

---

## ACID Properties

ACID defines how transactions behave safely in a database.

### Atomicity
A transaction is all-or-nothing.

If any step fails, the whole transaction is rolled back.

---

### Consistency
The database always remains in a valid state.

Constraints (PRIMARY KEY, FOREIGN KEY, etc.) are enforced.

---

### Isolation
Transactions do not interfere incorrectly with each other.

Each transaction behaves as if it is running alone.

---

### Durability
Once a transaction is committed, the data is permanently saved.

Even in case of crashes.

---

## ACID Example (Concurrency Problem)

Two users try to update the same bank account at the same time.

Initial balance: 100

Transaction A:
- reads 100 and version 1
- select * FROM accounts where id = 1000
- subtracts 50 → plans to write 50
- it also changes version to 2

Transaction B:
- reads 100 and version 1
- subtracts 30 → plans to write 70
- update account set money = 70, version=version+1 where id = 1000 and version = 1;

Without proper isolation:
- A writes 50
- B writes 70

Final result: 70 (wrong)

Correct result should be: 20

This problem is called a **lost update**.

---

## Locking Strategies

### Pessimistic Locking

The system assumes conflicts will happen.

When a row is read, it is locked.

```sql

BEGIN TRANSACTION;

SELECT * FROM accounts
WHERE id = 1
FOR UPDATE; --? may not be necessary

--NOW ALL OTHERS WAIT

UPDATE accounts SET balance = 50 WHERE id = 1;

COMMIT;
```

- Other transactions must wait
- Safe but slower

---

### Optimistic Locking

The system assumes conflicts are rare.

Each row has a version number.

```sql
UPDATE accounts
SET balance = 50, version = version + 1
WHERE id = 1 AND version = 3;
```

- If version changed → update fails
- Application retries

- Faster, but requires handling conflicts

---

## DDL vs DML

### DDL (Data Definition Language)

Defines structure:

```sql
CREATE TABLE student (...);
ALTER TABLE student ADD column age INT;
DROP TABLE student;
```

---

### DML (Data Manipulation Language)

Works with data:

```sql
INSERT INTO student VALUES (...);
UPDATE student SET name = 'Ali';
DELETE FROM student WHERE id = 1;
SELECT * FROM student;
```

---

## Primary Keys and Data Structure

Primary keys define how rows are identified.

They also affect:

- indexing
- joins
- storage layout

A table without a primary key:
- allows duplicates
- breaks relationships
- becomes harder to query efficiently

---

## Indexing (Introduction)

An index helps the database find data faster without checking every row.

Think of the index at the back of a book. To find a topic, you look it up in the index and go to the relevant page instead of reading the whole book.

### 1. Searching without an index

Imagine a `student` table with one million rows:

```sql
SELECT *
FROM student
WHERE email = 'samira@example.com';
```

Without a suitable index, the database needs to check every row to find matching students. This is called a **full table scan** (*sequential scan* in PostgreSQL).

### 2. Creating an index

We can create an index on the `email` column:

```sql
CREATE INDEX idx_student_email
ON student(email);
```

This creates a separate data structure containing email values and references to their rows.

PostgreSQL uses a **B-tree index** by default. It keeps values organised so the database can locate a value efficiently.

The query stays the same:

```sql
SELECT *
FROM student
WHERE email = 'samira@example.com';
```

**You do not mention the index in your SELECT query.** The database decides whether using it is useful.

> An index does not guarantee that the database will use it. For a small table, or a query returning most rows, scanning the table may be faster.

### 3. What does an index cost?

Indexes make some searches faster, but they require **extra storage** and **maintenance**.

| Operation | Effect of an index |
|---|---|
| `SELECT` | Can find matching rows faster |
| `INSERT` | Must add an entry to the index |
| `UPDATE` | May need to update index entries |
| `DELETE` | Creates index cleanup work; in PostgreSQL, cleanup usually happens later |

For example, changing a student's email also means updating the index on `email`.

**More indexes mean more storage and more work when data changes.**

### 4. Which columns should we index?

Start with the queries your application actually runs.

Columns used frequently in these clauses can be good candidates:

- **`WHERE`** — finding particular rows, such as a student by email.
- **`JOIN`** — finding related rows, such as enrollments for a student.
- **`ORDER BY`** — retrieving rows in a particular order.

However, **a column appearing in a query does not automatically mean it needs an index.** The benefit depends on the table size, the query, and how many rows match.

For example:

```sql
CREATE INDEX idx_enrollment_student_id
ON enrollment(student_id);
```

This index can help the database find a particular student's enrollments:

```sql
SELECT *
FROM enrollment
WHERE student_id = 10;
```

> **PostgreSQL automatically creates indexes for `PRIMARY KEY` and `UNIQUE` constraints. It does not automatically create an index on the referencing column of a foreign key.**

### Key idea

**Create indexes to support useful queries. Avoid adding an index to every column.**

---

## How Databases Store Data (B+ Trees)

Most relational databases use **B+ Trees** internally.

Not binary trees.

### Why not binary tree?

Binary trees:
- can become unbalanced
- inefficient for disk storage

---

### B+ Tree Characteristics

- balanced tree structure
- optimized for disk access
- nodes store ranges of values
- leaf nodes are linked (good for range queries)

---

### Simplified Idea

Instead of scanning the whole table:

- database navigates the tree
- jumps directly to matching data

---

### Important Connection

- PRIMARY KEY → usually indexed
- INDEX → implemented using B+ Tree

This is why:

- searching by ID is fast
- joins on keys are efficient

---

## Users, Roles, and Permissions

Databases support access control.

Not every user can do everything.

---

### Example Roles

- admin → full access
- developer → read + write
- analyst → read only

---

### Grant Permissions

```sql
GRANT SELECT, INSERT ON student TO app_user;
```

---

### Restrict Permissions

```sql
REVOKE UPDATE ON student FROM app_user;
```

---

### Why This Matters

- Prevent accidental data changes
- Improve security
- Separate responsibilities

Example:

- frontend app → cannot delete data
- reporting user → cannot modify data

---

# SQL Dialects (T-SQL, PL/SQL)

SQL has different implementations.

---
# SQL Dialects and Database Programming (Overview)

So far, we have used SQL to:

- create tables
- insert data
- query data

However, real databases can do more than just store and retrieve data.

They can also execute logic.

This is where database-specific SQL extensions come in.

---

## What Is a SQL Dialect?

SQL is a standard language.

But each database system extends it with additional features.

Examples:

- PostgreSQL → PL/pgSQL
- Microsoft SQL Server → T-SQL
- Oracle → PL/SQL

These extensions allow:

- variables
- loops
- conditions
- procedural logic

---

## Why Does This Exist?

In real-world systems, sometimes:

- logic must run close to the data
- performance matters (less network calls)
- data consistency must be enforced

Instead of sending many queries from the application:

 database can handle logic internally

---

## T-SQL (Microsoft SQL Server)

T-SQL extends SQL with programming features.

---

### Example

```sql
DECLARE @count INT;

SELECT @count = COUNT(*) FROM student;

PRINT @count;
```

---

### What Is Happening?

- a variable is declared (`@count`)
- a query result is assigned to it
- the value is printed

---

### Real-World Usage

T-SQL is commonly used for:

- reporting queries
- batch jobs
- scheduled database tasks
- data transformations
- stored procedures in enterprise systems

Example:

- calculate monthly revenue
- generate reports overnight
- clean or migrate data

---

## PL/SQL (Oracle)

PL/SQL is Oracle’s procedural extension.

It allows loops and control structures.

---

### Example

```sql
BEGIN
FOR i IN 1..5 LOOP
DBMS_OUTPUT.PUT_LINE(i);
END LOOP;
END;
```

---

### What Is Happening?

- a block of code is executed
- a loop runs from 1 to 5
- values are printed

---

### Real-World Usage

PL/SQL is heavily used in:

- banking systems
- legacy enterprise applications
- financial data processing
- complex business rules

Example:

- calculate interest for thousands of accounts
- validate transactions
- enforce business rules

---

## Where Does This Fit in Architecture?

There are two main approaches:

### 1. Application-driven logic
- logic is written in Java, Node.js, etc.
- database is mostly storage

### 2. Database-driven logic
- logic is written inside the database
- database becomes more powerful

Most modern systems prefer:

 logic in application  
 database for storage + constraints

But many real systems still use database logic.

---

## Related Concepts (Preview)

These features are part of database programming.

You will see them in real systems.

We will cover them later.

---

### Stored Procedure

A stored procedure is:

- a reusable piece of code stored in the database
- can contain SQL + logic

Common keywords:

```sql
CREATE PROCEDURE ...
CREATE FUNCTION ...
```

---

### Trigger

A trigger is:

- code that runs automatically when data changes

Common keywords:

```sql
CREATE TRIGGER ...
BEFORE INSERT
AFTER UPDATE
```

---

## When Will You Use These?

As a backend developer:

- you may read existing stored procedures
- you may debug triggers
- you may write simple database functions

In some companies (especially enterprise):

- heavy database logic is common

---

## Important Note

These features are powerful, but:

- they make systems harder to understand
- they are database-specific (not portable)

---

## Summary

- SQL dialects extend SQL with programming features
- T-SQL and PL/SQL allow variables, loops, and logic
- databases can execute logic, not just store data
- stored procedures and triggers are part of this ecosystem
- modern systems use them carefully

---

## Tip

Ask yourself:

- "Should business logic live in the database or application?"
- "What are the risks of hiding logic inside the database?"

This creates a good architecture discussion.
---

Core SQL is the same, but extensions differ.

---

# SQL Injection

SQL injection is a security vulnerability.

It occurs when user input is directly inserted into SQL queries.

---

### Unsafe Example

```sql
SELECT * FROM users
WHERE username = 'admin' AND password = '1234';
```

User input:

' OR '1'='1

Becomes:

```sql
SELECT * FROM users
WHERE username = '' OR '1'='1';
```

This returns all users.

---

## Prevention

- Use prepared statements
- Avoid string concatenation
- Validate input
- Use frameworks


# Database Tools

Use these visual tools to connect and manage your databases easily:

| Tool                | Database      | Description                        |
|---------------------|---------------|------------------------------------|
| **pgAdmin**         | PostgreSQL    | Official GUI for PostgreSQL        |
| **MySQL Workbench** | MySQL         | Official GUI for MySQL             |
| **DBeaver**         | All databases | Universal, cross-platform SQL tool |
---

## Summary

- ACID ensures correct transactions
- Locking prevents conflicts
- Primary keys define identity and structure
- Indexes improve performance using B+ Trees
- Permissions control access
- SQL dialects extend core SQL
- SQL injection is a critical risk
