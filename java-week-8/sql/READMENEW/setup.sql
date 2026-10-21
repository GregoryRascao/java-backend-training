-- Shared teaching data for README1.md through README4.md.
-- Run in SQL Tutorial Playground or a PostgreSQL query editor.
-- RESET: rerunning this script deletes and recreates ONLY these three demo tables.
-- Use these names only for this lesson; save any work you want to keep first.
DROP TABLE IF EXISTS enrollment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         student_id INT PRIMARY KEY,
                         full_name VARCHAR(100) NOT NULL,
                         age INT NOT NULL CHECK (age >= 0),
                         city VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE course (
                        course_id INT PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        code VARCHAR(20) UNIQUE,
                        hours INT NOT NULL CHECK (hours > 0)
);

CREATE TABLE enrollment (
                             student_id INT NOT NULL,
                             course_id INT NOT NULL,
                             enrolled_on DATE NOT NULL,
                             grade NUMERIC(5,2) CHECK (grade BETWEEN 0 AND 100),
                             PRIMARY KEY (student_id, course_id),
                             FOREIGN KEY (student_id) REFERENCES student(student_id),
                             FOREIGN KEY (course_id) REFERENCES course(course_id)
);

INSERT INTO student (student_id, full_name, age, city, email)
VALUES
    (1, 'Kien Ahmed', 24, 'Brussels', 'kien@example.com'),
    (2, 'Malek Janssen', 29, 'Antwerp', 'malek.janssen@example.com'),
    (3, 'Charlotte Peeters', 21, 'Brussels', 'charlotte@example.com'),
    (4, 'Paul Janssens', 35, 'Ghent', 'paul@example.com'),
    (5, 'Gayatri Yilmaz', 29, 'Brussels', 'gayatri@example.com');

INSERT INTO course (course_id, title, code, hours)
VALUES
    (10, 'Java', 'JAVA-101', 60),
    (20, 'SQL', 'DB-101', 20),
    (30, 'Spring Boot', 'SPRING-101', 40),
    (40, 'Docker', 'DOCKER-101', 10);

INSERT INTO enrollment (student_id, course_id, enrolled_on, grade)
VALUES
    (1, 10, '2026-10-01', 80),
    (1, 20, '2026-10-02', 90),
    (1, 30, '2026-10-03', NULL),
    (2, 10, '2026-10-01', 70),
    (2, 20, '2026-10-02', 80),
    (3, 20, '2026-10-02', 100),
    (5, 10, '2026-10-01', 90);

SELECT * FROM student ORDER BY student_id;