-- Exercise 4: Many-to-many with a junction table
-- Goal: Model many-to-many properly

-- Scenario:
-- A student can join many clubs.
-- A club can have many students.

-- Task 1: Create table students
-- - student_id INT PRIMARY KEY
-- - full_name VARCHAR(100) NOT NULL

-- Task 2: Create table clubs
-- - club_id INT PRIMARY KEY
-- - club_name VARCHAR(100) UNIQUE

-- Task 3: Create table student_club_membership
-- - student_id INT NOT NULL
-- - club_id INT NOT NULL
-- - joined_on DATE
-- - PRIMARY KEY (student_id, club_id)
-- - FOREIGN KEY (student_id) references students(student_id)
-- - FOREIGN KEY (club_id) references clubs(club_id)

-- Task 4: Insert sample rows to prove:
-- - one student can be in multiple clubs
-- - one club can contain multiple students

-- Write your SQL below:
