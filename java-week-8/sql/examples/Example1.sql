-- Example 1: CREATE TABLE with PRIMARY KEY and UNIQUE

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE course (
    course_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    code VARCHAR(20) UNIQUE
);
