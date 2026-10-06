
# Week 6: Java I/O, Streams/Lambda, Testing, Serialization, SQL and Multithreading

This week focuses on practical backend fundamentals in Java: reading and writing files, functional-style data processing, testing basics, object persistence with serialization, SQL foundations, and multithreading intro.

## Topics Covered

### File I/O: Reading and Writing

- Reading text files with `FileReader` and `BufferedReader`
- Writing and appending files with `FileWriter` and `BufferedWriter`
- Using `try-with-resources` for safe resource handling
- Handling `FileNotFoundException` and `IOException`

### Streams and Lambda Expressions

- Building and using lambda expressions
- Functional interfaces: `Predicate`, `BiFunction`
- Stream operations: `filter`, `map`, `mapToInt`, `collect`
- Sorting with lambda comparators
- Grouping and counting with `Collectors.groupingBy` and `Collectors.counting`

### Testing Fundamentals (Without External Libraries)

- Java `assert` usage and runtime flag `-ea`
- Writing custom assertion helper methods
- Arrange-Act-Assert testing structure
- Testing normal, edge, and error cases

### Serialization and Deserialization

- `Serializable` marker interface
- Writing objects with `ObjectOutputStream`
- Reading objects with `ObjectInputStream`
- Using `transient` fields and serialization rules

### SQL Foundations

- Core SQL statements: `CREATE TABLE`, `INSERT`, `UPDATE`
- Constraints: `PRIMARY KEY`, `UNIQUE`, `FOREIGN KEY`
- Relationship modeling: one-to-many and many-to-many
- SQL Developer vs DBA role overview
- JDBC motivation for next modules

### Multithreading Basics

- Creating threads with `Runnable` and `Thread`
- Difference between `start()` and `run()`
- Basic control with `sleep()` and `join()`
- Race conditions and thread-safety basics
- Intro to synchronization with `synchronized`

## Activities

- Implemented file reading and writing exercises with buffered I/O
- Practiced stream pipelines for filtering, mapping, aggregation, and grouping
- Wrote assertion-based tests and simple custom test utilities
- Serialized and deserialized single objects and collections
- Created relational schemas and solved SQL exercises with constraints and relationships
- Built simple multithreading examples and fixed race conditions using synchronization

## Learning Outcomes

By the end of Week 6, students can:

- Read and write files safely and efficiently in Java
- Apply lambda expressions and stream operations to solve data-processing tasks
- Write basic tests using Java assertions and clear test structure
- Persist and restore object state through serialization/deserialization
- Design basic relational models with SQL constraints and relationships
- Explain core multithreading concepts and avoid common concurrency mistakes