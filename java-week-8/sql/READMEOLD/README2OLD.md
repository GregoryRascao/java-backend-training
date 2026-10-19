# 🔍 Introduction to SELECT in SQL

 The `SELECT` statement is used to **retrieve data from a database**.

 It is the most commonly used SQL command.

---

 ## Basic Syntax

 ```sql
SELECT column1, column2
FROM table_name;
```

---

## Example Table

Assume we have a table:

```sql
CREATE TABLE STUDENT (
          student_id INT PRIMARY KEY,
          full_name VARCHAR(100),
          age INT,
          email VARCHAR(100)
);
```

---

## 🟢 1. Select All Columns

```sql
SELECT * FROM STUDENT;
```

- `*` means: get all columns
- Useful for quick checks
- ❗ Not recommended in production

---

## 🟡 2. Select Specific Columns

```sql
SELECT full_name, age FROM STUDENT;
```

- Only selected columns are returned
- Better for performance and clarity

---

## 🔵 3. WHERE (Filtering)

Used to filter rows.

```sql
SELECT * FROM STUDENT
WHERE age > 20;
```

---

### Common Operators

- `=` equal  
- `!=` or `<>` not equal  
- `>` greater than  
- `<` less than  
- `>=`, `<=`  

---

## 🟣 4. AND / OR

```sql
SELECT * FROM STUDENT
WHERE age > 18 AND age < 30;
```

```sql
SELECT * FROM STUDENT
WHERE age < 18 OR age > 60;
```

---

## 🟠 5. LIKE (Pattern Search)

```sql
SELECT * FROM STUDENT
WHERE full_name LIKE 'A%';
```

- `'A%'` → starts with A  
- `'%a'` → ends with a  
- `'%an%'` → contains "an"  

---

## 🔴 6. ORDER BY (Sorting)

```sql
SELECT * FROM STUDENT
ORDER BY age;
```

Default: ascending (ASC)

```sql
SELECT * FROM STUDENT
ORDER BY age DESC;
```

---

## ⚫ 7. LIMIT (Restrict Results)

```sql
SELECT * FROM STUDENT
                  LIMIT 5;
```

- Returns first 5 rows
- Useful for pagination

---

## 🟤 8. DISTINCT (Unique Values)

```sql
SELECT DISTINCT age FROM STUDENT;
```

- Removes duplicate values

---

## 🧠 9. COUNT (Aggregation)

```sql
SELECT COUNT(*) FROM STUDENT;
```

```sql
SELECT COUNT(*) FROM STUDENT
WHERE age > 20;
```

---

## 🧩 Combining Everything

```sql
SELECT full_name, age
FROM STUDENT
WHERE age > 18
ORDER BY age DESC
    LIMIT 3;
```

---

## ⚠️ Common Mistakes

❌ Forgetting `WHERE` → updates/selects everything  
❌ Using `SELECT *` everywhere  
❌ Confusing `=` and `LIKE`  
❌ Forgetting `ORDER BY` direction  

---

## 🎯 Mental Model

Think of SELECT like a pipeline:

 1. FROM → choose table
 2. WHERE → filter rows
 3. SELECT → pick columns
        4. ORDER BY → sort
        5. LIMIT → reduce results

---

## 🧪 Practice Ideas

1. Get all STUDENT older than 25
2. Get names starting with "M"
3. Get the youngest student
4. Count how many STUDENT are above 18

---