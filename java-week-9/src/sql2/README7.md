# GROUP BY and HAVING and Aggregate Functions

A join can show every enrollment with its student and course. Sometimes we need a smaller result: one row per course, with the number of students and their average grade.

These examples use the `student`, `course`, and `enrollment` tables in `school_db`. Keep asking: **what does one row represent at this point in the query?** Before grouping, it may be one enrollment. After grouping, it may be one course summary.

## 1. Calculate one result from several rows

An aggregate function calculates a result from a set of rows:

| Function | What it calculates |
| --- | --- |
| `COUNT(*)` | Number of rows |
| `COUNT(column)` | Number of non-null values in that column |
| `AVG(column)` | Average of the non-null values |
| `SUM(column)` | Total of the non-null values |
| `MIN(column)` / `MAX(column)` | Lowest / highest non-null value |

```sql
ALTER TABLE IF EXISTS public.enrollment
    ADD COLUMN grade smallint DEFAULT 80;
-- then change some grades

SELECT COUNT(*) AS enrollment_count,
       COUNT(grade) AS recorded_grades,
       AVG(grade) AS average_grade,
       MIN(grade) AS lowest_grade,
       MAX(grade) AS highest_grade
FROM enrollment;
```

The current data has eight enrollments, all with recorded grades. The average is `83.625`, the lowest is `70`, and the highest is `100`. Since no grade is `NULL` in this dataset, `COUNT(*)` and `COUNT(grade)` both return `8`. In a dataset with missing grades, `COUNT(grade)` would count only the non-`NULL` grades.

`AVG(grade)` also ignores `NULL` values; a missing grade does not contribute a zero to the average.

For a more natural example of a sum:

```sql
SELECT SUM(hours) AS total_course_hours
FROM course;
```

The result is `55`: 5 + 10 + 40. We are adding the durations of the three courses, not counting student attendance hours.

When no rows match, `COUNT` returns `0`; these other aggregates return `NULL`. For example, an average over no recorded grades is unknown, not automatically zero.

### `COUNT(*)` and `COUNT(1)`

`COUNT(*)` counts rows. `COUNT(1)` counts the non-`NULL` values of the expression `1`. Since `1` is a constant and is never `NULL`, both return the same count:

```sql
SELECT COUNT(*) AS row_count,
       COUNT(1) AS also_row_count
FROM enrollment;
```

There is no practical performance advantage to choosing `COUNT(1)` over `COUNT(*)` in modern databases. Prefer `COUNT(*)` when the question is “How many rows are there?” because it states that intent directly.

This is different from `COUNT(column)`, which ignores rows where that column is `NULL`. Also, after a `LEFT JOIN`, `COUNT(1)` counts the preserved row for an unmatched left-side record, just like `COUNT(*)`; use a non-nullable column from the right-side table when you need to count only matches.

## 2. Calculate one result per group

```sql
SELECT course_id, COUNT(*) AS student_count
FROM enrollment
GROUP BY course_id
ORDER BY course_id;
```

| course_id | student_count |
| --- | --- |
| 10 | 2 |
| 20 | 3 |
| 30 | 3 |

`GROUP BY` collects rows with the same course ID into a group. `COUNT(*)` then counts the rows in each group. We get one result row per course that has enrollments.

All three courses currently have enrollments. Grouping does not invent a group for a course with no matching enrollment; use a `LEFT JOIN` to include such courses with a count of zero.

## 3. Group by identity and show a readable name

```sql
SELECT c.id, c.title,
       COUNT(*) AS student_count,
       AVG(e.grade) AS average_grade
FROM course AS c
JOIN enrollment AS e
    ON c.id = e.course_id
GROUP BY c.id, c.title
ORDER BY c.id;
```

| course_id | title | student_count | average_grade |
| --- | --- | --- | --- |
| 10 | Hibernate Basics | 2 | 84 |
| 20 | Database Design | 3 | 86 |
| 30 | Intro To Programming | 3 | 81 |

Group by the course ID as well as the title so that two different courses with the same title are not accidentally merged. The same applies to students: a name is not a unique identity.

For our queries, put each selected non-aggregate column in `GROUP BY`. PostgreSQL can also accept some columns that are functionally dependent on a grouped primary key, but listing both ID and title keeps these examples explicit.

**Discuss:** why can we show `AVG(e.grade)` here, but not one ordinary `e.grade` for the Database Design group? It has three grades; a summary needs to say what to do with them.

## 4. Include groups with zero matches

```sql
SELECT c.id, c.title,
       COUNT(e.id) AS student_count,
       COUNT(e.grade) AS recorded_grades,
       AVG(e.grade) AS average_grade
FROM course AS c
LEFT JOIN enrollment AS e
    ON c.id = e.course_id
GROUP BY c.id, c.title
ORDER BY c.id;
```

| course_id | title | student_count | recorded_grades | average_grade |
| --- | --- | --- | --- | --- |
| 10 | Hibernate Basics | 2 | 2 | 84 |
| 20 | Database Design | 3 | 3 | 86 |
| 30 | Intro To Programming | 3 | 3 | 81 |

All current courses have matching enrollments, so this dataset does not show the zero-match case. If a course had no enrollment, the `LEFT JOIN` would preserve it with `NULL` enrollment columns. **`COUNT(*)` would count that preserved row as one.** `COUNT(e.id)` counts actual enrollment matches and returns zero for that course.

Here, `COUNT(e.grade)` matches the enrollment count because all eight enrollments have grades. With a missing grade, it would count fewer rows than `COUNT(e.id)`.

## 5. Filter groups with HAVING

```sql
SELECT c.id, c.title, COUNT(*) AS student_count
FROM course AS c
JOIN enrollment AS e
    ON c.id = e.course_id
GROUP BY c.id, c.title
HAVING COUNT(*) > 2
ORDER BY c.id;
```

This returns Database Design and Intro To Programming, with three enrollments each. `HAVING` checks each group's count after grouping.

| Clause | What it filters | Example question |
| --- | --- | --- |
| `WHERE` | Individual input rows | Which enrollments have a grade of at least 80? |
| `HAVING` | Groups | Which courses have more than two enrollments? |

An aggregate such as `COUNT(*)` cannot be used directly in this query's `WHERE` clause, because the groups have not been formed at that stage.

## 6. Use WHERE and HAVING together

```sql
SELECT c.id, c.title,
       COUNT(*) AS qualifying_students,
       AVG(e.grade) AS average_grade
FROM course AS c
JOIN enrollment AS e
    ON c.id = e.course_id
WHERE e.grade >= 80
GROUP BY c.id, c.title
HAVING COUNT(*) >= 2
ORDER BY average_grade DESC, c.id;
```

| course_id | title | qualifying_students | average_grade |
| --- | --- | --- | --- |
| 20 | Database Design | 2 | 91 |

Read this as: “Keep enrollments graded at least 80, group them by course, and show courses with at least two qualifying enrollments.”

Database Design's average is now `91`, because only its grades of `100` and `82` remain after filtering. This is different from averaging all grades first and asking whether that average is at least 80.

A useful reasoning order is `FROM`/`JOIN` → `WHERE` → `GROUP BY` → `HAVING` → `SELECT` → `ORDER BY` → `LIMIT`. It describes the query's meaning, not a fixed physical execution plan.

## 7. Ask a question from the student's side

```sql
SELECT s.id, s.name, COUNT(*) AS course_count
FROM student AS s
JOIN enrollment AS e
    ON s.id = e.student_id
GROUP BY s.id, s.name
HAVING COUNT(*) > 2
ORDER BY s.id;
```

Danieel and Omar each appear with three courses. The unique constraint on `(student_id, course_id)` ensures that each row is a distinct student–course pair, so counting these rows counts each student's courses.

If a later query joins another one-to-many table, it can multiply rows again. Check what one joined row represents before trusting a count or sum. Adding `DISTINCT` without understanding those rows can hide a mistake.

## Optional: use a query as an input to IN

We previously used `IN` with a list of values. A subquery can produce that list:

```sql
SELECT s.id, s.name
FROM student AS s
WHERE s.id IN (
    SELECT e.student_id
    FROM enrollment AS e
    WHERE e.grade > 80
)
ORDER BY s.id;
```

This returns Daniel and Omar: students with at least one grade above 80. The subquery must return `e.student_id` to match the outer student's ID.

To find students with no enrollments, another option is `NOT EXISTS`:

```sql
SELECT s.id, s.name
FROM student AS s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollment AS e
    WHERE e.student_id = s.id
)
ORDER BY s.id;
```

This returns Alice, Alize, Ulpan, and Ulpan2, who have no enrollments. The inner query refers to the current outer student. `EXISTS` checks whether any matching row exists; the selected `1` is simply a placeholder.

Be careful with `NOT IN` when the list or subquery can contain `NULL`: for a value without an equal match, the result can become unknown instead of true, so `WHERE` excludes it. Our enrollment student IDs cannot be null, but that is not true of every dataset. Choose `IN` or `EXISTS` for the meaning you need; neither is universally faster.

## Short checks

1. In a dataset with missing grades, why might `COUNT(*)` and `COUNT(grade)` differ?
2. How would a `LEFT JOIN` show a course that has no enrollments?
3. How does `WHERE grade >= 80` change the values included in an average?

For a first pass, stop before the optional subqueries if the class needs more time with grouping. Understanding the rows being counted matters more than adding more syntax.

Reference: [PostgreSQL aggregate functions](https://www.postgresql.org/docs/16/functions-aggregate.html).
