# Reading Data with SELECT

We can now store students in a table. The next question is how to retrieve the students we need. A `SELECT` statement produces a result table; it does not change the stored rows.

Use the data from [setup.sql](setup.sql). If you changed it during a previous demonstration, reset it first so the expected results below match.

## 1. Choose the columns

```sql
SELECT *
FROM lesson_students
ORDER BY student_id;
```

`*` selects every column. This is useful when inspecting a table. When writing a query for a specific purpose, name the columns you need:

```sql
SELECT full_name, age
FROM lesson_students
ORDER BY student_id;
```

The database still contains email addresses and cities; this result simply does not include them. Choosing columns is different from choosing rows.

## 2. Choose the rows with WHERE

```sql
SELECT full_name, age
FROM lesson_students
WHERE age > 25
ORDER BY student_id;
```

| full_name | age |
| --- | --- |
| Malek Janssen | 29 |
| Paul Janssens | 35 |
| Gayatri Yilmaz | 29 |

`WHERE` keeps rows for which the condition is true. Here, we check each student's age, then return the requested columns for the matching students.

| Operator | Meaning |
| --- | --- |
| `=` | Equal to |
| `<>` or `!=` | Not equal to |
| `>` / `<` | Greater than / less than |
| `>=` / `<=` | Greater than or equal to / less than or equal to |

SQL uses `=` for equality, unlike Java's `==`. A `SELECT` without `WHERE` is perfectly valid when we want all rows.

## 3. Combine conditions

```sql
SELECT full_name, age, city
FROM lesson_students
WHERE city = 'Brussels' AND age >= 24
ORDER BY student_id;
```

This returns Kien and Gayatri. With `AND`, both conditions must be true. With `OR`, at least one must be true:

```sql
SELECT full_name, city
FROM lesson_students
WHERE city = 'Brussels' OR city = 'Antwerp'
ORDER BY student_id;
```

This returns Kien, Malek, Charlotte, and Gayatri. Use parentheses when mixing the operators:

```sql
SELECT full_name
FROM lesson_students
WHERE (city = 'Brussels' OR city = 'Antwerp')
  AND age >= 25
ORDER BY student_id;
```

Now only Malek and Gayatri match. SQL evaluates `AND` before `OR`; parentheses make the intended grouping explicit.

**Predict:** would Kien match if we changed `AND age >= 25` to `AND age >= 24`?

## 4. Use IN and BETWEEN for common filters

`IN` checks membership in a list of values:

```sql
SELECT full_name, city
FROM lesson_students
WHERE city IN ('Brussels', 'Antwerp')
ORDER BY student_id;
```

This has the same meaning as the earlier two-city `OR` condition. `NOT IN ('Brussels', 'Antwerp')` would keep Paul.

`BETWEEN` includes both ends of a range:

```sql
SELECT full_name, age
FROM lesson_students
WHERE age BETWEEN 24 AND 29
ORDER BY student_id;
```

Kien, Malek, and Gayatri match. This means `age >= 24 AND age <= 29`. Use `NOT BETWEEN` to exclude the range.

The same idea works with our `DATE` column:

```sql
SELECT student_id, course_id, enrolled_on
FROM lesson_enrollments
WHERE enrolled_on BETWEEN '2026-10-01' AND '2026-10-02'
ORDER BY student_id, course_id;
```

Both dates are included, giving six enrollments. A timestamp also contains a time: an upper bound at midnight would not include the rest of that day. We will return to timestamp ranges when we need them.

## 5. Match text patterns with LIKE

```sql
SELECT full_name
FROM lesson_students
WHERE full_name LIKE 'S%'
ORDER BY student_id;
```

This returns Kien Ahmed. `%` matches zero or more characters; `_` matches exactly one character.

| Pattern | Meaning |
| --- | --- |
| `'S%'` | Starts with S |
| `'%a'` | Ends with a |
| `'%ar%'` | Contains ar |
| `'_eo%'` | Any first character, then eo, then any remaining characters |

For ordinary PostgreSQL text matching, `LIKE` is case-sensitive. PostgreSQL also provides `ILIKE` for case-insensitive matching:

```sql
SELECT full_name
FROM lesson_students
WHERE full_name ILIKE 's%'
ORDER BY student_id;
```

This also returns Kien. Use `=` for an exact value and `LIKE`/`ILIKE` when you need a pattern.

## 6. Check missing values with IS NULL

```sql
SELECT student_id, course_id, grade
FROM lesson_enrollments
WHERE grade IS NULL;
```

This returns Kien's Spring Boot enrollment: student `1`, course `30`.

Use `IS NULL` or `IS NOT NULL`, rather than `= NULL` or `<> NULL`. Comparisons such as `grade > 80` do not match an unknown grade. `WHERE` keeps true conditions; an unknown result is not true.

An unrecorded grade and a grade of zero mean different things. Do not replace one with the other just to simplify a query.

## 7. Sort, then limit

```sql
SELECT full_name, age
FROM lesson_students
ORDER BY age DESC, student_id ASC
LIMIT 3;
```

| full_name | age |
| --- | --- |
| Paul Janssens | 35 |
| Malek Janssen | 29 |
| Gayatri Yilmaz | 29 |

`DESC` means descending; `ASC` means ascending and is the default. The second sort column resolves the tie between Malek and Gayatri.

`LIMIT 3` returns at most three rows. Without `ORDER BY`, there is no guaranteed “first three.” If a particular order matters, request it explicitly.

## 8. Remove duplicates or count rows

```sql
SELECT DISTINCT city
FROM lesson_students
ORDER BY city;
```

This returns Antwerp, Brussels, and Ghent once each. It does not delete duplicate city values from the table. With several selected columns, `DISTINCT` removes duplicate combinations of those values.

To count matching rows instead:

```sql
SELECT COUNT(*) AS student_count
FROM lesson_students
WHERE city = 'Brussels';
```

The result is one row containing `3`. `AS student_count` gives the result column a useful label; it does not rename a stored column. We will explore aggregate functions in [README4.md](README4.md).

## 9. Read a query as a question

```sql
SELECT full_name, age
FROM lesson_students
WHERE city = 'Brussels'
ORDER BY age DESC, student_id
LIMIT 2;
```

The question is: “Who are the two oldest students in Brussels?” The result is Gayatri, then Kien.

A useful reasoning order is `FROM` → `WHERE` → `SELECT` → `ORDER BY` → `LIMIT`. This explains the meaning of this query; it is not a promise about the database's physical execution steps.

## Short checks

Before running each query, predict its result:

1. Change the final query to `ORDER BY age ASC, student_id`. Who appears first?
2. What happens if `LIMIT 2` becomes `LIMIT 10`?
3. Can `grade = NULL` find an unrecorded grade?

Next: [relationships and JOINs](README3.md).
