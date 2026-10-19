# 🔗 Introduction to JOINs in SQL

JOINs are used to **combine data from multiple tables**.

In real-world applications, data is split across tables:
- users
- orders
- products

JOIN allows us to bring them together.

---

## 🧠 Why JOIN?

Tables are connected using **FOREIGN KEY relationships**.

Example:

- One customer → many orders
- Each order → belongs to one customer

We JOIN tables to see combined data.

---

## Example Tables

```sql
CREATE TABLE customers (
customer_id INT PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE orders (
order_id INT PRIMARY KEY,
customer_id INT,
total DECIMAL(10,2),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```

---

## 🟢 1. INNER JOIN

Returns **only matching rows**.

```sql
SELECT customers.name, orders.total
FROM customers
INNER JOIN orders
ON customers.customer_id = orders.customer_id;
```

👉 Only customers who have orders will appear.

---

## 🟡 2. LEFT JOIN

Returns:
- all rows from left table
- matching rows from right table

```sql
SELECT customers.name, orders.total
FROM customers
LEFT JOIN orders
ON customers.customer_id = orders.customer_id;
```

👉 Customers without orders → `NULL`

---

## 🔵 3. RIGHT JOIN

Returns:
- all rows from right table
- matching rows from left table

```sql
SELECT customers.name, orders.total
FROM customers
RIGHT JOIN orders
ON customers.customer_id = orders.customer_id;
```

👉 Less commonly used (LEFT JOIN preferred)

---

## 🔴 4. JOIN with Multiple Tables

```sql
SELECT c.name, o.order_id, o.total
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id;
```

👉 Using aliases:
- `c` → customers
- `o` → orders

---

## 🟣 5. Many-to-Many JOIN

Example: students ↔ courses

```sql
CREATE TABLE students (
student_id INT PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE courses (
course_id INT PRIMARY KEY,
title VARCHAR(100)
);

CREATE TABLE ENROLLMENT (
student_id INT,
course_id INT,
PRIMARY KEY (student_id, course_id)
);
```

---

### Querying Many-to-Many

```sql
SELECT s.name, c.title
FROM students s
JOIN ENROLLMENT e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id;
```

👉 This is a **2-step join**

---

## 🧩 JOIN Mental Model

Think like this:

- FROM → starting table
- JOIN → bring another table
- ON → how they are connected

---

## ⚠️ Common Mistakes

❌ Missing `ON` condition → huge wrong result (cartesian product)  
❌ Joining wrong columns  
❌ Confusing LEFT vs INNER  
❌ Not using aliases (makes queries unreadable)

---

## 🎯 INNER vs LEFT (Very Important)

| JOIN Type   | Result |
|------------|--------|
| INNER JOIN | Only matching rows |
| LEFT JOIN  | All left + matches |

👉 Most used in real life:
- INNER JOIN
- LEFT JOIN

---

## 🧪 Practice Ideas

1. Show all customers and their orders
2. Show customers without orders
3. Show all orders with customer names
4. Show all students and their courses

---


## 🧠 Simple Rule

- INNER JOIN → strict
- LEFT JOIN → forgiving

---

## 🚀 Next Step

After JOINs, you can learn:

- GROUP BY
- HAVING
- Aggregations with JOIN

👉 This is where SQL becomes powerful.
You can go ahead and solve Project 1 until the question 25.