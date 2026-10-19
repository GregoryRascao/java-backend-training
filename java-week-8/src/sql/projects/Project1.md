# Project: School Management Reporting

## Goal

In this project, you will work with a small school database.

The database is already designed and filled with sample data.

Your job is to write SQL queries to answer real-world questions.

This project combines topics you have already seen:

- `CREATE TABLE`
- `INSERT INTO`
- `PRIMARY KEY`
- `UNIQUE`
- `FOREIGN KEY`
- one-to-many
- many-to-many
- `SELECT`
- `WHERE`
- `ORDER BY`
- `JOIN`

---

## Scenario

A school wants to keep track of:

- teachers
- departments
- students
- courses
- enrollments

Rules:

- One department can have many teachers
- One department can have many courses
- One teacher belongs to one department
- One course belongs to one department
- One course is taught by one teacher
- One student can join many courses
- One course can have many students

---

## Database Setup

Run the following SQL first.

```sql
CREATE TABLE departments (
department_id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE teachers (
teacher_id INT PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE,
department_id INT NOT NULL,
FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE students (
student_id INT PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE,
age INT NOT NULL
);

CREATE TABLE courses (
course_id INT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
department_id INT NOT NULL,
teacher_id INT NOT NULL,
FOREIGN KEY (department_id) REFERENCES departments(department_id),
FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

CREATE TABLE enrollments (
student_id INT NOT NULL,
course_id INT NOT NULL,
enrolled_on DATE,
grade DECIMAL(5,2),
PRIMARY KEY (student_id, course_id),
FOREIGN KEY (student_id) REFERENCES students(student_id),
FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
```

---

## Sample Data

```sql
INSERT INTO departments (department_id, name) VALUES
(1, 'Computer Science'),
(2, 'Mathematics'),
(3, 'Physics');

INSERT INTO teachers (teacher_id, full_name, email, department_id) VALUES
(1, 'Sophie Lambert', 'sophie.lambert@school.be', 1),
(2, 'Thomas Dubois', 'thomas.dubois@school.be', 2),
(3, 'Julie Peeters', 'julie.peeters@school.be', 3),
(4, 'Lucas Maes', 'lucas.maes@school.be', 1),
(5, 'Gayatri Claes', 'gayatri.claes@school.be', 2);

INSERT INTO students (student_id, full_name, email, age) VALUES
(1, 'Louis Janssens', 'louis.janssens@student.be', 19),
(2, 'Gayatri Peeters', 'gayatri.peeters@student.be', 21),
(3, 'Oleg Dubois', 'Oleg.dubois@student.be', 20),
(4, 'Mila Claes', 'mila.claes@student.be', 22),
(5, 'Jules Maes', 'jules.maes@student.be', 18),
(6, 'Lina Vermeulen', 'lina.vermeulen@student.be', 23),
(7, 'Arthur Wouters', 'arthur.wouters@student.be', 20),
(8, 'Nina Martens', 'nina.martens@student.be', 21),
(9, 'Seppe Dierckx', 'seppe.dierckx@student.be', 19),
(10, 'Elise Goossens', 'elise.goossens@student.be', 22);

INSERT INTO courses (course_id, title, department_id, teacher_id) VALUES
(1, 'Introduction to Programming', 1, 1),
(2, 'Database Fundamentals', 1, 4),
(3, 'Calculus I', 2, 2),
(4, 'Linear Algebra', 2, 5),
(5, 'Physics I', 3, 3),
(6, 'Algorithms', 1, 1),
(7, 'Data Structures', 1, 4),
(8, 'Statistics', 2, 2);

INSERT INTO enrollments (student_id, course_id, enrolled_on, grade) VALUES
(1, 1, '2026-02-01', 78.50),
(1, 2, '2026-02-02', 85.00),
(1, 3, '2026-02-03', 69.50),

(2, 1, '2026-02-01', 91.00),
(2, 4, '2026-02-04', 88.50),
(2, 8, '2026-02-05', 84.00),

(3, 2, '2026-02-02', 73.00),
(3, 3, '2026-02-03', 80.00),
(3, 5, '2026-02-06', 67.50),

(4, 4, '2026-02-04', 92.00),
(4, 5, '2026-02-06', 89.00),
(4, 8, '2026-02-07', 94.50),

(5, 1, '2026-02-01', 60.00),
(5, 6, '2026-02-08', 71.00),

(6, 2, '2026-02-02', 95.00),
(6, 6, '2026-02-08', 90.50),
(6, 7, '2026-02-09', 93.00),

(7, 3, '2026-02-03', 76.00),
(7, 4, '2026-02-04', 81.50),

(8, 5, '2026-02-06', 86.00),
(8, 8, '2026-02-07', 79.00),

(9, 1, '2026-02-01', 68.00),
(9, 7, '2026-02-09', 74.00),

(10, 2, '2026-02-02', 87.00),
(10, 4, '2026-02-04', 90.00),
(10, 8, '2026-02-05', 88.00);
```

---

## Project Tasks

Write SQL queries for the following questions.

Go from top to bottom.

Try to solve each task before moving to the next one.

---

## Part 1: Simple SELECT

### Task 1
Show all students.

### Task 2
Show only student names and ages.

### Task 3
Show all courses.

### Task 4
Show all teachers ordered by full name.

---

## Part 2: Filtering with WHERE

### Task 5
Show students older than 20.

### Task 6
Show students whose age is exactly 19.

### Task 7
Show courses that belong to the Computer Science department.

### Task 8
Show enrollments where the grade is greater than 85.

---

## Part 3: Sorting

### Task 9
Show all students ordered by age from youngest to oldest.

### Task 10
Show all enrollments ordered by grade from highest to lowest.

### Task 11
Show all courses ordered by title alphabetically.

---

## Part 4: Basic JOINs

### Task 12
Show each teacher together with their department name.

Expected columns:
- teacher name
- department name

### Task 13
Show each course together with its department name.

Expected columns:
- course title
- department name

### Task 14
Show each course together with the teacher who teaches it.

Expected columns:
- course title
- teacher name

---

## Part 5: Many-to-Many JOINs

### Task 15
Show each student together with the courses they joined.

Expected columns:
- student name
- course title

### Task 16
Show each enrollment with:
- student name
- course title
- grade

### Task 17
Show all students enrolled in `Database Fundamentals`.

### Task 18
Show all courses taken by `Gayatri Peeters`.

---

## Part 6: More Realistic Reporting

### Task 19
Show all courses with their department and teacher.

Expected columns:
- course title
- department name
- teacher name

### Task 20
Show all students with grades above 90.

Expected columns:
- student name
- course title
- grade

### Task 21
Show all students who are enrolled in at least one Mathematics course.

### Task 22
Show all courses where the grade is below 70 for at least one student.

---

## Part 7: Ordering and Limiting Results

### Task 23
Show the top 5 highest grades in the system.

Expected columns:
- student name
- course title
- grade

### Task 24
Show the 3 youngest students.

### Task 25
Show the 3 courses with the alphabetically smallest titles.

---

## Part 8: Challenge Queries

### Task 26
Show each department with its teachers.

Expected columns:
- department name
- teacher name

Order by department name, then teacher name.

### Task 27
Show each department with its courses.

Expected columns:
- department name
- course title

Order by department name, then course title.

### Task 28
Show all students and the number of courses they joined.

Expected columns:
- student name
- number of courses

### Task 29
Show all courses and the number of students enrolled in each course.

Expected columns:
- course title
- number of students

### Task 30
Show the average grade for each course.

Expected columns:
- course title
- average grade

### Task 31
Show the average grade for each student.

Expected columns:
- student name
- average grade

### Task 32
Show the highest grade in each course.

Expected columns:
- course title
- highest grade

### Task 33
Show the students who are enrolled in more than 2 courses.

### Task 34
Show the courses that have more than 2 students.

---

## Bonus Tasks

### Bonus 1
Show the department that offers the most courses.

### Bonus 2
Show the teacher whose courses have the highest average grade.

### Bonus 3
Show the student with the highest average grade.

### Bonus 4
Show all students who never received a grade below 70.

---

## Tips

- Start with simple `SELECT`
- Then use `WHERE`
- Then use `ORDER BY`
- Then use `JOIN`
- For challenge tasks, you may need:
    - `COUNT`
    - `AVG`
    - `MAX`
    - `GROUP BY`
    - `HAVING`

---

## Reflection Questions

After finishing the project, answer these questions:

1. Why is `enrollments` a junction table?
2. Why is the relationship between students and courses many-to-many?
3. Why do we need both `department_id` and `teacher_id` in the `courses` table?
4. Which queries were easiest for you?
5. Which queries were hardest for you?