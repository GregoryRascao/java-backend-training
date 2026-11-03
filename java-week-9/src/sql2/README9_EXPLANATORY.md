# Database Command Line Basics (PostgreSQL & MySQL)

A database client lets you send commands to a database server and read the results.
You have already done this through a graphical tool. Now we will do it from a terminal.
This is useful when running scripts, working on servers, and creating or testing backups.

Follow the PostgreSQL examples first. The MySQL section shows the equivalent workflow.
The final section introduces database-side logic; treat it as optional practice.

## 1. Before You Start: Where Does a Command Run?

There are three kinds of commands in this lesson:

| Kind | Where you type it | Example |
|---|---|---|
| Terminal command | PowerShell, Command Prompt, Bash, or Git Bash | `psql -U postgres -d school_cli` |
| Client command | Inside `psql` or the `mysql` client | `\dt` or `SOURCE practice.sql;` |
| SQL statement | Inside a database client or an SQL file | `SELECT * FROM student;` |

**Always check where a code block should run before copying it.**
For example, `pg_dump` starts a separate program: it belongs in your terminal.

You need a running database server, the relevant command-line tools, and a database account.
Installing Git Bash alone does not install PostgreSQL or MySQL tools.
If a command is “not found” or “not recognized”, check installation and your `PATH`.

We use a separate practice database named `school_cli` and one table named `student`.
Use the database username supplied for your installation. `postgres` is the example PostgreSQL account.
The MySQL examples use `username` as a placeholder: replace it with your account name.

## 2. PostgreSQL: Connect and Prepare Your Practice Database
### Step 1 — Open psql from your terminal

**Terminal:**

```bash
psql -h localhost -p 5432 -U postgres -d postgres
```

Here, `localhost` means the server is on your computer, `5432` is the port,
`postgres` after `-U` is the database user, and `postgres` after `-d` is an existing database.
Enter your password if requested. These values may differ on your installation.

You will see a prompt such as `postgres=#`. You are now inside `psql`.
Do not copy the prompt itself when entering commands.
### Step 2 — Create and connect to the practice database

**Inside psql:**

```sql
CREATE DATABASE school_cli;
```

```text
\c school_cli
```

Run `CREATE DATABASE` only once. It requires permission to create databases.
If your teacher has already created this database, connect to it directly.
### Step 3 — Create a small table and add sample data

**SQL inside psql:**

```sql
CREATE TABLE student (
    student_id INTEGER PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INTEGER CHECK (age >= 0)
);

INSERT INTO student (student_id, full_name, age)
VALUES (1, 'Alisan', 25),
       (2, 'Gregory', 31),
       (3, 'Samira', 28);

SELECT * FROM student ORDER BY student_id;
```

We supply IDs manually here so the same table definition works in MySQL.
Run this setup once in an empty practice database.
You should see three rows. Keep this data for the next sections.

## 3. PostgreSQL: Explore the Database

These commands belong to **psql**. Commands beginning with `\` are client meta-commands;
they are not SQL statements and normally do not end with a semicolon.

| Task | psql command |
|---|---|
| List databases | `\l` |
| Connect to another database | `\c school_cli` |
| List tables visible through the current search path | `\dt` |
| Describe a table: columns, constraints, indexes | `\d student` |
| Show connection details | `\conninfo` |
| Show psql command help | `\?` |
| Show SQL help for a statement | `\h SELECT` |
| Exit psql and return to your terminal | `\q` |

Try `\d student`. Can you find the primary key and the check constraint?
Then run a query:

```sql
SELECT full_name, age
FROM student
WHERE age >= 28;
```

SQL statements end with `;`. If you forget it, psql waits for the rest of your statement.
If output opens in a pager, press `q` to return to the prompt.

## 4. Run an SQL File

An SQL file is a text file containing statements you would otherwise type manually.
Save the following as `practice.sql` using a text editor:

```sql
SELECT COUNT(*) AS student_count FROM student;
SELECT full_name FROM student ORDER BY full_name;
```
### Option A — Run it inside psql

```text
\i practice.sql
```

The path refers to a file on the computer running psql, not the database server.
A relative path starts from psql's current working directory.
For a path with spaces, use quotes: `\i 'C:/SQL lessons/practice.sql'`.
### Option B — Run it directly from your terminal

Exit psql with `\q`, then run:

```bash
psql -h localhost -U postgres -d school_cli -v ON_ERROR_STOP=1 -f practice.sql
```\

`-f` reads the file. `ON_ERROR_STOP=1` stops execution when an error occurs.
It does **not** automatically undo statements that have already committed.
This is useful for repeatable setup scripts and automated tasks.

In Bash, Git Bash, or Windows Command Prompt, input redirection is another option:

```bash
psql -h localhost -U postgres -d school_cli < practice.sql
```

Here, `<` is a shell operator that sends file contents into a program.
PowerShell does not support this input-redirection syntax; use psql's `-f` option there.

## 5. PostgreSQL: Back Up and Restore

A logical backup records how to recreate database objects and their data.
A restore executes that information against a target database.
For this exercise, restore into a **new database** so you can compare the two copies.
### Step 1 — Export the practice database

**Terminal:**

```bash
pg_dump -h localhost -U postgres -d school_cli -f school_backup.sql
```

This produces a plain SQL file. Open it in a text editor and look for table definitions and data.
By default, PostgreSQL commonly writes table data using `COPY`, rather than individual `INSERT`s.
This exports one database; cluster-wide objects such as database roles are not included.
### Step 2 — Create an empty restore target

Connect to PostgreSQL and run this **SQL**, outside a transaction:

```sql
CREATE DATABASE school_restore;
```
### Step 3 — Load the backup into the new database

**Terminal:**

```bash
psql -h localhost -U postgres -d school_restore -v ON_ERROR_STOP=1 -f school_backup.sql
```

The target must already exist for this example. Use a new, empty target.
Loading a dump into a populated database can cause conflicts or change existing objects.
### Step 4 — Verify the result

Connect to `school_restore`, then inspect the restored table and data:

```sql
SELECT COUNT(*) AS student_count FROM student;
SELECT * FROM student ORDER BY student_id;
```

Compare the rows and constraints with the source database. A file existing on disk does not prove restoration works.
### Useful export options

**Terminal — these are separate alternatives:**

```bash
pg_dump -h localhost -U postgres -d school_cli --schema-only -f structure.sql
pg_dump -h localhost -U postgres -d school_cli --data-only -f data.sql
pg_dump -h localhost -U postgres -d school_cli --inserts -f inserts_backup.sql
```

`--schema-only` exports definitions; `--data-only` exports data and requires compatible existing tables.
`--inserts` makes row loading easier to read, but restoration is usually slower than with `COPY`.
It does not automatically make the complete dump compatible with MySQL.

PostgreSQL also supports custom-format archives, restored with `pg_restore`.
Our examples use plain SQL dumps, so we restore them with `psql`.

## 6. MySQL: The Same Workflow with Different Commands

Use a separate MySQL server for this section. PostgreSQL and MySQL do not share databases.

### Step 1 — Connect from your terminal

```bash
mysql -h 127.0.0.1 -P 3306 -u username -p
```

`-u` selects the user; `-p` asks for a password. Do not put the password in the command.
`-P` specifies the port. Notice the capital letter: these options are case-sensitive.
The prompt changes to `mysql>` when you connect.

### Step 2 — Create and select the practice database

**Inside the MySQL client:**

```sql
CREATE DATABASE school_cli;
USE school_cli;
```

Run the table creation and sample inserts from section 2 in this database.
For the transaction exercises, use an InnoDB table; this is MySQL's usual default engine.

### Step 3 — Inspect the database

```sql
SHOW DATABASES;
SHOW TABLES;
DESCRIBE student;
SHOW CREATE TABLE student;
SELECT DATABASE();
```

`DESCRIBE` gives a column overview. `SHOW CREATE TABLE` shows the full definition,
including constraints and the storage engine.
Use `exit` to return to your terminal.

### Step 4 — Run a file

**Inside the MySQL client:**

```text
SOURCE practice.sql;
```

`SOURCE` is a mysql client command, not server-side SQL.
For this example, start the client from the folder containing the file.

**From Bash, Git Bash, or Windows Command Prompt:**

```bash
mysql -h 127.0.0.1 -u username -p school_cli < practice.sql
```

In PowerShell, open the MySQL client and use `SOURCE` instead of `<`.

### Step 5 — Export and restore into a new database

**Terminal:**

```bash
mysqldump -h 127.0.0.1 -u username -p --single-transaction --result-file=mysql_backup.sql school_cli
```

`--result-file` writes directly to a file, avoiding shell-specific output encoding issues.
`--single-transaction` gives a consistent snapshot for InnoDB data.
Avoid schema changes during this dump; this option does not guarantee consistency for nontransactional tables.
Triggers are included by default; add `--routines --events` if those objects also need exporting.

**SQL inside the MySQL client:**

```sql
CREATE DATABASE school_restore;
USE school_restore;
```

**Then, inside the same client:**

```text
SOURCE mysql_backup.sql;
```

This example dumps one database without `--databases`, then loads it into the selected empty target.
Check the rows and table definition as you did in PostgreSQL.
A dump created with different options can contain its own database-selection statements.

## 7. Make Changes Safely with Transactions

A transaction groups work into a unit that can be committed or rolled back.
In the usual default autocommit mode, each successful standalone statement commits automatically.
Start an explicit transaction **before** the change when you want a chance to inspect and undo it.

### Step 1 — Check the row you intend to change

Connect to `school_cli` and run:

```sql
SELECT * FROM student WHERE student_id = 2;
```

### Step 2 — Start a transaction, change the row, and inspect it

The following works in PostgreSQL and in MySQL with InnoDB:

```sql
START TRANSACTION;

UPDATE student
SET age = age + 1
WHERE student_id = 2;

SELECT * FROM student WHERE student_id = 2;
```

Your session sees Gregory's new age. The transaction is still open.
The `WHERE` clause limits the update to one student; without it, every row would be updated.

### Step 3 — Choose one ending

For this practice, undo the change:

```sql
ROLLBACK;
```

Run the `SELECT` again: Gregory's age should be back to 31.
If you wanted to keep the change, you would use `COMMIT;` **instead of** `ROLLBACK;`.
Finish transactions promptly: an open transaction may hold locks that make other sessions wait.

### What if someone runs DELETE without WHERE?

`DELETE FROM student;` attempts to remove every row, subject to constraints and triggers.
What happens next depends on whether the deletion committed:

| Situation | Next step |
|---|---|
| Deletion is in an open, uncommitted transaction | Use `ROLLBACK` in that same session |
| Deletion has committed, including through autocommit | `ROLLBACK` cannot undo it; investigate recovery options |
| You do not know the transaction state | Involve the responsible developer or DBA before making more changes |

For committed data loss, restore a suitable backup into a separate database first.
Recover the needed data after checking it; blindly replacing the live database could lose newer valid changes.
Recovery to a moment before the mistake requires suitable backups and logs configured in advance.
A server outage also needs diagnosis: a crashed service does not automatically mean the data needs restoring.

In MySQL, many DDL statements, including ordinary `CREATE TABLE`, `ALTER TABLE`, and `DROP TABLE`,
cause implicit commits. Do not assume the rollback exercise applies to all SQL commands.

## 8. Optional PostgreSQL Concepts: Logic Inside the Database

The following examples run in **PostgreSQL only**, in `school_cli`, after the earlier setup.
They use PostgreSQL syntax; MySQL has different syntax and capabilities.

### A. Sequence — Generate the Next Number

A sequence is a database object that generates numbers safely for concurrent callers.
For this exercise, create a separate sequence and request values:

```sql
CREATE SEQUENCE demo_seq START WITH 100;
SELECT nextval('demo_seq'); -- 100 on the first call
SELECT nextval('demo_seq'); -- 101 on the next call
```

This sequence is not connected to `student`: it simply demonstrates number generation.
For an automatically generated table ID, PostgreSQL offers `GENERATED ... AS IDENTITY`,
which uses a sequence internally. MySQL commonly uses `AUTO_INCREMENT`.

Sequence values can have gaps: a rollback does not return a consumed value.
An ID is an identifier, not a reliable count of rows. Keep a `PRIMARY KEY` or `UNIQUE` constraint to enforce uniqueness.

### B. Trigger — React Automatically to a Change

Suppose we want a log entry whenever a student is inserted.
First, create the table that will receive those entries:

```sql
CREATE TABLE student_logs (
    log_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

Next, define what the trigger will do:

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

`NEW` contains the inserted row; `||` joins text. `$$` marks the function body's boundaries.
`plpgsql` is PostgreSQL's procedural language. The `BEGIN`/`END` here delimit a code block;
they do not start and commit a transaction.

Now attach the function to the table:

```sql
CREATE TRIGGER student_insert_trigger
AFTER INSERT ON student
FOR EACH ROW
EXECUTE FUNCTION log_student_insert();
```

`AFTER INSERT` chooses the event and timing; `FOR EACH ROW` runs the function once per inserted row.
The returned value is ignored for this AFTER trigger; `RETURN NEW` is a conventional ending here.
Test it once:

```sql
INSERT INTO student (student_id, full_name, age) VALUES (4, 'Charlotte', 27);
SELECT * FROM student_logs;
```

You should see a log message for Charlotte. Existing students are not logged retroactively.
The log insert belongs to the same transaction: rolling back the student insert also rolls back its log.
Triggers can also react to updates or deletions, but automatic side effects can make debugging harder.

### C. Function and Procedure — Call Database Logic Explicitly

Both store reusable logic in the database. They are different object types.
Here is a small function that calculates a value:

```sql
CREATE FUNCTION age_next_year(p_age INTEGER)
RETURNS INTEGER AS $$
    SELECT p_age + 1;
$$ LANGUAGE sql;

SELECT full_name, age_next_year(age) AS age_next_year FROM student;
```

This function returns a value for use in a query; it does not change the stored age.
Functions can also modify data, so “function means read-only” is not a general rule.

A procedure is called with `CALL`. Here is one that changes a student's age:

```sql
CREATE PROCEDURE increase_age(p_student_id INTEGER)
LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student
    SET age = age + 1
    WHERE student_id = p_student_id;
END;
$$;

CALL increase_age(1);
SELECT * FROM student WHERE student_id = 1;
```

Each call increases Alisan's age again. For a reversible test, wrap the call in a transaction and roll it back.
The procedure changes nothing if the supplied ID does not exist.

## 9. Practice and Check Your Understanding

1. Connect to `school_cli`, list its tables, and describe `student`.
2. Save a query selecting students aged 28 or older in a file and run it through the client.
3. Update Samira's age inside a transaction, inspect it, roll back, and verify the original value.
4. Back up the database and restore into a new empty database. Compare rows and constraints.
5. Explain why a committed `DELETE` cannot be fixed with `ROLLBACK`.
6. Optional: insert another student and check the trigger log. Why is no explicit function call needed?

Keep backups regularly, protect them like the original data, and test restoration.
For production work, follow your team's access, change, and recovery procedures.
Operating-system administrator access (`sudo`) and database permissions are separate concepts;
using `sudo` is not a general solution to database connection or permission errors.

## Official Documentation

- [PostgreSQL: psql](https://www.postgresql.org/docs/current/app-psql.html)
- [PostgreSQL: pg_dump](https://www.postgresql.org/docs/current/app-pgdump.html)
- [PostgreSQL: sequence functions](https://www.postgresql.org/docs/current/functions-sequence.html)
- [PostgreSQL: trigger functions](https://www.postgresql.org/docs/current/plpgsql-trigger.html)
- [PostgreSQL: CREATE PROCEDURE](https://www.postgresql.org/docs/current/sql-createprocedure.html)
- [MySQL: execute SQL from a file](https://dev.mysql.com/doc/refman/8.4/en/mysql-batch-commands.html)
- [MySQL: mysqldump](https://dev.mysql.com/doc/refman/8.4/en/mysqldump.html)
- [MySQL: statements that cause implicit commits](https://dev.mysql.com/doc/refman/8.4/en/implicit-commit.html)
