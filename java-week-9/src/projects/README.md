#  **10 Project Ideas for Week 6 – Databases & JDBC**

---

## 1.  **Student Management System**

**Concepts:** CRUD, PreparedStatement, ResultSet mapping

* Create a database table `students` (id, name, age, email).
* Implement:

    * Add new student
    * List all students
    * Find student by ID
    * Update student email
    * Delete student
* Optional: use `Scanner` to interact with the user.

---

## 2.  **Library Book Tracker**

**Concepts:** Foreign keys, JOINs, transactions

* Tables:

    * `books(id, title, author, available)`
    * `borrowers(id, name)`
    * `loans(id, book_id, borrower_id, loan_date)`
* Features:

    * Borrow and return books (update `available`)
    * List all borrowed books
    * Rollback if a book is already borrowed

---

## 3.  **Expense Tracker**

**Concepts:** INSERT, SELECT with conditions, aggregation

* Table: `expenses(id, category, amount, date)`
* Features:

    * Add expenses
    * Show all expenses
    * Filter by category
    * Calculate total spending

---

## 4. ‍ **Employee Payroll System**

**Concepts:** CRUD, UPDATE, PreparedStatement

* Table: `employees(id, name, position, salary)`
* Features:

    * Add/update employee salary
    * View all employees
    * Calculate total payroll

---

## 5.  **Bank Account Simulator**

**Concepts:** Transactions, rollback, commit

* Table: `accounts(id, owner, balance)`
* Features:

    * Deposit/withdraw funds
    * Transfer between accounts (use transactions)
    * Rollback if funds insufficient

---

## 6.  **Online Store Inventory**

**Concepts:** CRUD + relationships

* Tables:

    * `products(id, name, price, stock)`
    * `orders(id, product_id, quantity, total)`
* Features:

    * Add products
    * Make a purchase (update stock)
    * Prevent purchase if stock too low

---

## 7. ‍ **User Authentication System**

**Concepts:** PreparedStatement, SQL injection prevention

* Table: `users(id, username, password)`
* Features:

    * Register (INSERT)
    * Login (SELECT with PreparedStatement)
    * Prevent SQL injection

---

## 8.  **Course Enrollment System**

**Concepts:** Many-to-many relationship, JOINs

* Tables:

    * `students(id, name)`
    * `course(id, title)`
    * `enrollments(student_id, course_id)`
* Features:

    * Enroll student in course
    * View courses per student
    * Handle duplicate enrollments

---

## 9.  **Log Management Tool**

**Concepts:** File I/O + Database integration

* Read logs from a `.log` file
* Store log entries in `logs(level, message, timestamp)` table
* Generate report: count of INFO, WARNING, ERROR

---

## 10.  **Configuration Manager (DB Edition)**

**Concepts:** CRUD + serialization alternative

* Table: `settings(id, key, value)`
* Features:

    * Load settings from DB
    * Update configuration
    * Restore defaults

---

#  **Learning Outcomes**

By completing these projects, students will:

* Design normalized relational databases
* Write and test CRUD queries using JDBC
* Handle exceptions and transactions safely
* Understand real-world persistence workflows
* Prepare for **Spring Boot + JPA (Week 8–9)**

---

