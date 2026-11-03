# Database Command Line Basics (PostgreSQL & MySQL)

These commands are useful when working with databases in real environments.

Focus on understanding what each command does.

---

## PostgreSQL (psql)

### Connecting to Database

```sql
psql -U username -d database_name
```

Example:

```sql
psql -U postgres -d school_db
```

---

### Listing Databases

```sql
\l
```

---

### Connecting to Another Database

```sql
\c database_name
```

---

### Listing Tables

```sql
\dt
```

---

### Describing a Table

```sql
\d students
```

---

### Running a SQL File

```sql
\i file.sql
```

---

### Exporting Database (Backup)

Note: This is a terminal command, not SQL.

```sql
pg_dump -U username -d database_name -f backup.sql
```

---

### Importing (Restore)

Note: This is a terminal command, not SQL.

```sql
psql -U username -d database_name -f backup.sql
```

---

### Bonus: Run SQL File Without Entering psql

Note: This is a terminal command, not SQL.

```sql
psql -U username -d database_name < file.sql
```

This runs a SQL file directly from the terminal.

---

### Useful pg_dump Options

```sql
pg_dump -U username -d database_name --inserts -f backup.sql
pg_dump -U username -d database_name --data-only -f data.sql
pg_dump -U username -d database_name --schema-only -f schema.sql
```

- `--inserts` → generates INSERT statements
- `--data-only` → only data (no CREATE TABLE)
- `--schema-only` → only structure (no data)

---

## MySQL (mysql client)

MySQL uses a different CLI tool.

### Connecting to Database

```sql
mysql -u username -p
```

---

### Listing Databases

```sql
SHOW DATABASES;
```

---

### Selecting a Database

```sql
USE database_name;
```

---

### Listing Tables

```sql
SHOW TABLES;
```

---

### Describing a Table

```sql
DESCRIBE students;
```

---

### Running a SQL File

```sql
SOURCE file.sql;
```

---

### Exporting Database (Backup)

```sql
mysqldump -u username -p database_name > backup.sql
```

---

### Importing (Restore)

```sql
mysql -u username -p database_name < backup.sql
```

---

## Key Differences

| Feature        | PostgreSQL | MySQL |
|----------------|-----------|-------|
| CLI Tool       | psql      | mysql |
| List DB        | \l        | SHOW DATABASES |
| List Tables    | \dt       | SHOW TABLES |
| Describe Table | \d table  | DESCRIBE table |
| Run File       | \i file   | SOURCE file |

---

## Important Notes

- Commands starting with `\` are PostgreSQL-specific
- MySQL uses SQL-like commands (SHOW, USE, etc.)
- Backup tools differ:
    - PostgreSQL → `pg_dump`
    - MySQL → `mysqldump`

---

# Real-World Database Scenarios

---

## Scenario 1: Production Database Failure

- database crashes
- data is corrupted
- table is deleted

### What Should You Do?

1. Stay calm
2. Do NOT run random queries
3. Check for backups

### Restore

Use the restore command shown above.

---

## Scenario 2: Accidental DELETE

```sql
DELETE FROM student;
```

All data is gone.

### What Now?

Use the restore command shown above.

---

## Scenario 3: Safe Updates with Transaction

```sql
BEGIN;

UPDATE student
SET age = age + 1;

ROLLBACK;
```

---

## PostgreSQL Backup with INSERT

```sql
pg_dump -U username -d database_name --inserts -f backup.sql
```

Pros:
- readable
- portable

Cons:
- slower
- larger

---

## Best Practices

- Take backups regularly
- Test your restore process
- Use transactions for risky operations
- Avoid direct production changes
- You may need sudo on Linux systems

---

# Advanced Database Concepts (Overview)

---

## Sequence

```sql
CREATE SEQUENCE student_seq START 1;
```

```sql
INSERT INTO students (student_id, full_name, age)
VALUES (nextval('student_seq'), 'Louis Janssens', 19);
```

---

## Trigger

Triggers run automatically on events:

- BEFORE INSERT
- AFTER INSERT
- BEFORE UPDATE
- AFTER UPDATE
- BEFORE DELETE
- AFTER DELETE

---

### Example

```sql
CREATE FUNCTION log_student_insert()
RETURNS TRIGGER AS $$
BEGIN
INSERT INTO student_logs(message)
VALUES ('New student added: ' || NEW.full_name);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;
```

```sql
CREATE TRIGGER student_insert_trigger
AFTER INSERT ON student
FOR EACH ROW
EXECUTE FUNCTION log_student_insert();
```

---

## Stored Procedure / Function

```sql
CREATE FUNCTION increase_age(p_student_id INT)
RETURNS VOID AS $$
BEGIN
UPDATE student
SET age = age + 1
WHERE student_id = p_student_id;
END;
$$ LANGUAGE plpgsql;
```

```sql
SELECT increase_age(1);
```

---

## Summary

| Concept            | Description |
|--------------------|------------|
| Sequence           | generates unique numbers |
| Trigger            | automatic logic on events |
| Stored Procedure   | logic inside database |

