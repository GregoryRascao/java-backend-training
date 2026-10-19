-- Exercise 3: One-to-many / many-to-one with FOREIGN KEY
-- Goal: Create linked tables and valid data

-- Task 1: Create table departments:
-- - department_id INT PRIMARY KEY
-- - name VARCHAR(100) UNIQUE

-- Task 2: Create table employees:
-- - employee_id INT PRIMARY KEY
-- - full_name VARCHAR(100) NOT NULL
-- - department_id INT NOT NULL
-- - FOREIGN KEY department_id references departments(department_id)

-- Write your CREATE TABLE statements below:


-- Task 3: Insert 2 departments and 4 employees
-- Make sure all employee department_id values exist in departments.

-- Write your INSERT statements below:


-- Reflection:
-- Why is this one-to-many?
-- Why is the reverse view many-to-one?
