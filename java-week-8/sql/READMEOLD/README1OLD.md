# 🗄️ Introduction to SQL (2 Days)

This module introduces core SQL fundamentals for backend developers.

Scope for now:
- Create tables
- Insert rows
- Update rows
- Understand `PRIMARY KEY`, `UNIQUE`, and `FOREIGN KEY`
- Understand relationships: one-to-many, many-to-one, and many-to-many

> We will use SQL directly in this module. **JDBC comes later** in a future module.

---

## Day Plan (2 Days)

### Day 1 -- SQL Basics + Constraints
- What SQL is and where it is used
- `CREATE TABLE`
- `INSERT INTO`
- `UPDATE`
- `PRIMARY KEY`
- `UNIQUE`
- `FOREIGN KEY` (intro)

### Day 2 -- Table Relationships + Roles
- One-to-many and many-to-one
- Many-to-many (with a junction table)
- **ER Diagrams (Crow’s Foot notation)**
- What a SQL Developer does
- What a SQL Administrator (DBA) does
- Practice with integrated exercises

---

## What SQL Is

SQL (Structured Query Language) is used to define, store, and modify data in relational databases.

Typical use cases:
- App user data
- Orders and products
- Reports and analytics
- Configuration and audit records

---

## Core Statements

### `CREATE TABLE`
Defines the structure of a table.

```sql
CREATE TABLE students (
student_id INT PRIMARY KEY,
email VARCHAR(100) UNIQUE,
full_name VARCHAR(100) NOT NULL
);
```

### `INSERT INTO`
Adds new rows.

```sql
INSERT INTO students (student_id, email, full_name)
VALUES (1, 'sara@example.com', 'Sara Ahmed');
```

### `UPDATE`
Changes existing rows.

```sql
UPDATE students
SET full_name = 'Sara A. Ahmed'
WHERE student_id = 1;
```

---

## Keys and Constraints

### `PRIMARY KEY`
- Uniquely identifies each row
- Cannot be `NULL`
- One primary key per table (can be composite)

### `UNIQUE`
- Prevents duplicate values in a column
- Usually allows one `NULL` value depending on database engine

### `FOREIGN KEY`
- Connects one table to another
- Enforces referential integrity
- Child table value must exist in parent table key

Example:

```sql
CREATE TABLE courses (
course_id INT PRIMARY KEY,
title VARCHAR(100) NOT NULL
);

CREATE TABLE enrollments (
enrollment_id INT PRIMARY KEY,
student_id INT NOT NULL,
course_id INT NOT NULL,
FOREIGN KEY (student_id) REFERENCES students(student_id),
FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
```

---

## Relationships

### One-to-many
One row in table A relates to many rows in table B.

Example: one `customer` can have many `orders`.

### Many-to-one
The reverse view of one-to-many.

Example: many `orders` belong to one `customer`.

### Many-to-many
Rows in table A relate to many rows in table B and vice versa.

Example: many `students` can join many `courses`.

Implementation pattern:
- Create a junction table, e.g. `enrollments(student_id, course_id)`
- Usually define a composite key over both columns

---

## 🗺️ Visualizing Relationships (ER Diagrams)

Understanding relationships is easier when we visualize them.

We use:

- **ER Diagrams (Entity-Relationship Diagrams)**
- **Crow’s Foot notation** (industry standard)

---

### What is an ER Diagram?

An ER Diagram shows:

- tables (entities)
- columns (attributes)
- relationships between tables

---

### Crow’s Foot Notation Basics

- `|` → exactly one
- `o` → optional (zero)
- `<` → many

---

### One-to-Many (ERD)

Customer |----< Order

- One customer can have many orders
- Each order belongs to one customer

Equivalent SQL:

```sql
CREATE TABLE customers (
customer_id INT PRIMARY KEY
);

CREATE TABLE orders (
order_id INT PRIMARY KEY,
customer_id INT,
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```

---

### Many-to-Many (ERD)

Student |----< Enrollment >----| Course

- A student can join many courses
- A course can have many students

---

### Why a Junction Table?

Relational databases **do not support many-to-many directly**.

```sql
CREATE TABLE enrollments (
student_id INT,
course_id INT,
PRIMARY KEY (student_id, course_id),
FOREIGN KEY (student_id) REFERENCES students(student_id),
FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
```

---

### ERD → SQL Mapping

| ERD Concept   | SQL Equivalent |
|--------------|----------------|
| Entity       | Table          |
| Attribute    | Column         |
| Relationship | Foreign Key    |
| Junction     | Join Table     |

---

### Simple Rule

- One-to-many → use **FOREIGN KEY**
- Many-to-many → use **junction table**

---

## Roles in Data Teams

### SQL Developer
A SQL developer typically:
- Writes SQL queries for features and reports
- Designs tables and relationships with the team
- Optimizes queries for app needs
- Builds data transformations and stored logic (depending on company)

### SQL Administrator (DBA)
A SQL admin/DBA typically:
- Installs/configures database servers
- Manages users, permissions, backups, restores
- Monitors performance, storage, and uptime
- Handles security, maintenance, and disaster recovery

Short version:
- SQL Developer = builds data solutions
- DBA = keeps the database healthy, secure, and available

---

## JDBC (Later)

In this module, we run SQL manually to understand the fundamentals.

In a future module, we will learn **JDBC** to execute SQL from Java applications.

---

## Where to Learn More SQL

- SQLBolt (interactive basics)
- Mode SQL Tutorial
- PostgreSQL official docs
- W3Schools SQL reference (quick lookup)
- LeetCode SQL / HackerRank SQL practice

Tip: Practice using one database engine first (PostgreSQL or MySQL) and stay consistent.

---

## Examples and Exercises

- Examples: [examples/Example1.sql](../examples/Example1.sql), [examples/Example2.sql](../examples/Example2.sql), [examples/Example3.sql](../examples/Example3.sql)
- Exercises: [exercises/Exercise1.sql](../exercises/Exercise1.sql), [exercises/Exercise2.sql](../exercises/Exercise2.sql), [exercises/Exercise3.sql](../exercises/Exercise3.sql), [exercises/Exercise4.sql](../exercises/Exercise4.sql)

---

## Learning Outcomes

After this 2-day module, students can:
- Create basic tables with constraints
- Insert and update data safely
- Explain `PRIMARY KEY`, `UNIQUE`, and `FOREIGN KEY`
- Model one-to-many and many-to-many relationships
- Understand ER diagrams and map them to SQL
- Distinguish SQL Developer vs DBA responsibilities
- Explain why JDBC is important and why it comes next