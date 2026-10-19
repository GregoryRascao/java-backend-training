-- Example 2: INSERT and UPDATE

INSERT INTO student (student_id, full_name, email)
VALUES
    (1, 'Kien Ahmed', 'kien@example.com'),
    (2, 'Malek Janssen', 'malek@example.com');

INSERT INTO course (course_id, title, code)
VALUES
    (10, 'Java Fundamentals', 'JAVA-101'),
    (20, 'Databases Intro', 'DB-101');

UPDATE student
SET email = 'malek.janssen@example.com'
WHERE student_id = 2;
