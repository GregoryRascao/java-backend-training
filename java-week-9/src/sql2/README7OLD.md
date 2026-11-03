# Introduction to GROUP BY, HAVING, and Aggregations in SQL

After learning `SELECT` and `JOIN`, the next step is to summarize data.

This is where SQL becomes more powerful.

In real projects, we often do not want to see every row one by one.

Instead, we want questions like:

- How many students are in each course?
- What is the average grade per course?
- Which students joined more than 2 courses?
- Which departments offer the most courses?

To answer these, we use:

- `COUNT`
- `AVG`
- `MAX`
- `MIN`
- `SUM`
- `GROUP BY`
- `HAVING`

---

## What Is an Aggregate Function?

An aggregate function calculates one result from many rows.

Common aggregate functions:

- `COUNT()` → counts rows
- `AVG()` → average value
- `SUM()` → total
- `MAX()` → highest value
- `MIN()` → lowest value

Example:

```sql
SELECT COUNT(*) FROM student;
```

This returns the total number of students.

---

## COUNT

### Count all rows

```sql
SELECT COUNT(*) FROM enrollment;
```

### Count non-null values in a column

```sql
SELECT COUNT(grade) FROM enrollment;
```

---

## AVG

```sql
SELECT AVG(grade) FROM enrollment;
```

This returns the average grade.

---

## MAX and MIN

```sql
SELECT MAX(grade) FROM enrollment;
```

```sql
SELECT MIN(grade) FROM enrollment;
```

---

## SUM

```sql
SELECT SUM(grade) FROM enrollment;
```

This is less common for grades, but useful for prices, salaries, quantities, and totals.

---

## Why GROUP BY?

Without `GROUP BY`, aggregate functions summarize the whole table.

But often we want one result per group.

Examples:

- one result per course
- one result per student
- one result per department

---

## Basic GROUP BY Example

```sql
SELECT course_id, COUNT(*)
FROM enrollment
GROUP BY course_id;
```

This means:

- group rows by `course_id`
- count how many rows are in each group

---

## GROUP BY Mental Model

Think like this:

1. Split rows into groups
2. Calculate something for each group
3. Return one row per group

---

## Example: Number of Students in Each Course

```sql
SELECT course_id, COUNT(*) AS student_count
FROM enrollment
GROUP BY course_id;
```

---

## Example: Average Grade Per Course

```sql
SELECT course_id, AVG(grade) AS average_grade
FROM enrollment
GROUP BY course_id;
```

---

## GROUP BY with JOIN

This is the most useful real-world version.

Instead of showing `course_id`, we usually want the course title.

```sql
SELECT c.title, COUNT(*) AS student_count
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title;
```

Now the result is easier to read.

---

## Another Example: Average Grade Per Student

```sql
SELECT s.full_name, AVG(e.grade) AS average_grade
FROM student s
JOIN enrollments e
ON s.student_id = e.student_id
GROUP BY s.full_name;
```

---

## Important Rule

If you use `GROUP BY`, every selected column must be:

- either grouped
- or aggregated

Correct:

```sql
SELECT course_id, COUNT(*)
FROM enrollment
GROUP BY course_id;
```

Incorrect:

```sql
SELECT course_id, enrolled_on, COUNT(*)
FROM enrollment
GROUP BY course_id;
```

Why incorrect?

Because `enrolled_on` is neither:
- in the `GROUP BY`
- nor inside an aggregate function

---

## HAVING

`HAVING` filters groups.

`WHERE` filters rows before grouping.

`HAVING` filters the grouped result after grouping.

---

## WHERE vs HAVING

### WHERE
Use `WHERE` for individual rows.

```sql
SELECT *
FROM enrollment
WHERE grade > 80;
```

---

### HAVING
Use `HAVING` for grouped results.

```sql
SELECT course_id, COUNT(*) AS student_count
FROM enrollment
GROUP BY course_id
HAVING COUNT(*) > 2;
```

This means:

- group by course
- count students in each course
- only keep courses with more than 2 students

---

## Example: Students Enrolled in More Than 2 Courses

```sql
SELECT s.full_name, COUNT(*) AS course_count
FROM student s
JOIN enrollments e
ON s.student_id = e.student_id
GROUP BY s.full_name
HAVING COUNT(*) > 2;
```

---

## Example: Courses With More Than 2 Students

```sql
SELECT c.title, COUNT(*) AS student_count
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title
HAVING COUNT(*) > 2;
```

---

## Example: Courses With Average Grade Above 85

```sql
SELECT c.title, AVG(e.grade) AS average_grade
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title
HAVING AVG(e.grade) > 85;
```

---

## ORDER BY with GROUP BY

You can sort grouped results too.

```sql
SELECT c.title, AVG(e.grade) AS average_grade
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title
ORDER BY average_grade DESC;
```

---

## Full Example

```sql
SELECT c.title, COUNT(*) AS student_count, AVG(e.grade) AS average_grade
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title
HAVING COUNT(*) > 1
ORDER BY average_grade DESC;
```

This query:

- joins courses and enrollments
- groups by course
- counts students
- calculates average grade
- keeps only courses with more than 1 student
- sorts by average grade

---

## Common Mistakes

### 1. Using WHERE instead of HAVING

Incorrect idea:

```sql
SELECT course_id, COUNT(*)
FROM enrollment
WHERE COUNT(*) > 2
GROUP BY course_id;
```

`WHERE` cannot filter aggregate results.

Use `HAVING` instead.

---

### 2. Selecting columns that are not grouped or aggregated

Incorrect:

```sql
SELECT c.title, e.grade
FROM course c
JOIN enrollments e
ON c.id = e.course_id
GROUP BY c.title;
```

`e.grade` is not grouped and not aggregated.

---

### 3. Forgetting that JOIN changes the number of rows

When you join tables, you may create more rows than expected.

Always think:

- what is one row now?
- what exactly am I counting?

---

## Tips for grouping

When you see a grouped query, ask:

1. What is the group?
2. What is being calculated?
3. Should filtering happen before grouping or after grouping?

If you can answer these three questions, you understand the query.

---

## Practice Ideas

### Basic
1. Count how many students exist
2. Find the highest grade
3. Find the average grade

### Intermediate
4. Count how many students are in each course
5. Show the average grade for each course
6. Show the highest grade for each student

### Advanced
7. Show students enrolled in more than 2 courses
8. Show courses with more than 2 students
9. Show departments that offer more than 2 courses
10. Show the teacher whose courses have the highest average grade

---

## Simple Rule

- `WHERE` filters rows
- `GROUP BY` creates groups
- aggregate functions calculate values
- `HAVING` filters groups

---

# IN Operator

The `IN` operator is used to match a value against a list of values.

It is a cleaner alternative to multiple `OR` conditions.

---

### Basic Example

```sql
SELECT *
FROM student
WHERE student_id IN (1, 2, 3);
```

This means:

- student_id = 1 OR student_id = 2 OR student_id = 3

---

### Equivalent with OR (less readable)

```sql
SELECT *
FROM student
WHERE student_id = 1
OR student_id = 2
OR student_id = 3;
```

---

### Example with Strings

```sql
SELECT *
FROM student
WHERE full_name IN ('Louis Janssens', 'Emma Peeters');
```

---

## IN with Subquery (Very Important)

`IN` is often used with another query.

---

### Example

```sql
SELECT *
FROM student
WHERE student_id IN (
SELECT student_id
FROM enrollment
);
```

This means:

👉 get all students who are enrolled in at least one course

---

## Example with JOIN Context

```sql
SELECT s.full_name
FROM student s
WHERE s.student_id IN (
SELECT e.student_id
FROM enrollment e
WHERE e.grade > 80
);
```

👉 students with at least one grade above 80

---

## NOT IN

You can also exclude values.

```sql
SELECT *
FROM student
WHERE student_id NOT IN (1, 2, 3);
```

---

## Important Warning

If `NULL` exists inside the list:

`NOT IN` may behave unexpectedly.

---

### Example Problem

```sql
SELECT *
FROM student
WHERE student_id NOT IN (
SELECT student_id FROM enrollment
);
```

If the subquery returns `NULL`, the result may be empty.

---

### Safer Alternative

```sql
SELECT *
FROM student s
WHERE NOT EXISTS (
SELECT 1
FROM enrollment e
WHERE e.student_id = s.student_id
);
```

---

## When Should You Use IN?

Use `IN` when:

- matching against a small list of values
- filtering with a subquery
- replacing multiple OR conditions

---

## When NOT to Use IN?

- very large lists (performance issue)
- when EXISTS is more efficient

---

## Summary

- `IN` = multiple OR conditions
- can be used with subqueries
- `NOT IN` can be tricky with NULL
- often replaced with `EXISTS` in advanced queries


## BETWEEN Operator

The `BETWEEN` operator is used to filter values within a range.

---

### Basic Example

```sql
SELECT *
FROM student
WHERE age BETWEEN 18 AND 21;
```

This means:

- age >= 18 AND age <= 21

---

### Important Rule

`BETWEEN` is **inclusive**:

- includes both start and end values

---

### Equivalent Without BETWEEN

```sql
SELECT *
FROM student
WHERE age >= 18 AND age <= 21;
```

---

### Example with Dates

```sql
SELECT *
FROM enrollment
WHERE enrolled_on BETWEEN '2026-02-01' AND '2026-02-10';
```

👉 very common in real-world queries

---

### Example with Grades

```sql
SELECT *
FROM enrollment
WHERE grade BETWEEN 70 AND 90;
```

---

## NOT BETWEEN

You can also exclude a range.

```sql
SELECT *
FROM student
WHERE age NOT BETWEEN 18 AND 21;
```

---

## Common Use Cases

- filtering by age ranges
- filtering by date ranges
- filtering by prices or scores

---

## Important Notes

- `BETWEEN` works with numbers, dates, and strings
- be careful with date boundaries (time may matter in real systems)

---

## Summary

- `BETWEEN` filters a range
- inclusive on both ends
- cleaner than writing >= AND <=

## Next Step

After this topic, you are ready for more realistic reporting questions such as:

- top-performing students
- courses with low average grades
- busiest departments
- teachers with the strongest course results

This is the point where SQL starts to feel like real reporting work.
You can solve remaining questions on Project1 now.

For more questions:
https://github.com/utkarshere/SQL-Interview-Questions-40
