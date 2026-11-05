# Introduction to Hibernate

Hibernate is a framework that helps Java applications work with relational databases in an object-oriented way.

Instead of writing SQL for every small operation, we can map Java classes to database tables and let Hibernate handle many common tasks for us.

In simple terms:

a Java object can represent a row in a table
a Java class can represent a table
Hibernate helps us save, read, update, and delete objects in the database

This idea is called ORM.

## What is ORM?

ORM stands for Object-Relational Mapping.

Relational databases store data in:

* tables
* rows
* columns

Java applications work with:

* classes
* objects
* fields

These two worlds are different.

ORM is the bridge between them.

Example:

* Student class ↔ students table
* name field ↔ name column
* one Student object ↔ one row in the table

Without ORM, we usually write SQL manually and then manually convert database rows into Java objects.

With ORM, much of this work becomes easier and cleaner.

## What is JPA?

JPA is **not** a framework by itself.
It is a **standard** or **a set of rules/interfaces** for persistence in Java.
Hibernate implements that standard. 
* Hibernate ORM 7.3 targets Jakarta Persistence 3.2
* Hibernate 6.6 targets Jakarta Persistence 3.1.

So:
* **JPA** = the specification / standard
* https://jakarta.ee/specifications/persistence/3.2/jakarta-persistence-spec-3.2.html
* https://jakarta.ee/specifications/persistence/3.2/
* https://jakarta.ee/specifications/persistence/3.2/jakarta-persistence-spec-3.2.pdf

* **Hibernate** = one implementation of that standard

A useful comparison:

JPA is like an interface
Hibernate is a class that implements it.

In real projects, developers often say “we use JPA”, but in practice they are usually using Hibernate underneath.

Other programming languages also have those solutions.
* Rust has Diesel
* Go has GORM
* Ruby has ActiveRecord
* PHP has Eloquent.
* TypeScript has Prisma,
* Drizzle ORM and Sequelize.
* Java has EclipseLink, MyBatis, JOOQ.
* We shouldn't pass without telling Spring Data JPA.

## Why do we use Hibernate?

Hibernate gives us several advantages.

### 1. Less repetitive code

With plain JDBC, we often write the same kinds of code again and again:

- open connection
- prepare SQL
- execute query
- read result set
- create objects manually

Hibernate reduces this repetitive work.

### 2. More object-oriented code

Instead of thinking only in tables and SQL rows, we can think in Java classes and objects.

That usually makes the code easier to read and maintain.

### 3. Easier entity relationships

Database relationships such as:

one-to-one
one-to-many
many-to-one
many-to-many

can be represented directly in Java classes.

### 4. Database independence

Hibernate still works with SQL databases, but it hides many database-specific details.

This makes it easier to switch databases later, at least for common operations.

### Does Hibernate remove SQL completely?

No.

This is very important.

Hibernate helps a lot, but it does not make SQL useless.

We still need SQL knowledge because:

databases are still relational
performance problems often require SQL understanding
complex queries may still need JPQL, HQL, or native SQL
we need to understand joins, indexes, and transactions

So Hibernate does not replace SQL knowledge.
It works together with SQL knowledge.

## Hibernate vs JDBC

Hibernate is built on top of JDBC ideas and still uses JDBC underneath for database communication.

A simple way to think about it:

> **JDBC** = lower level, more manual
> **Hibernate** = higher level, more automatic

With JDBC, you control almost everything yourself.
With Hibernate, you give more responsibility to the framework.

That makes development faster, but also means you must understand what the framework is doing behind the scenes.

### Which Hibernate version will we use?

For a new course, we will use Hibernate ORM 7.3, because it is the current latest stable series on the official Hibernate website. It is suitable for modern Java projects using Java 17 or newer.

If a project must stay on Java 11, Hibernate 6.6 is still an option, but it is already in limited maintenance mode, so it is not the best choice for a fresh training path.

### What will we learn first?

We will not start with everything at once.

First, we will learn the basic flow:

1. create an entity class
2. configure Hibernate
3. connect to the database
4. save an object
5. read objects from the database
6. update an object
7. delete an object

After that, we can continue with:

* primary keys
* entity lifecycle
* relationships
* JPQL / HQL
* lazy vs eager loading
* transactions
* validations
* common mistakes and performance issues

## In this module

In this Hibernate module, we will focus on:

* understanding the ORM idea, 
* mapping Java classes to database tables, 
* performing basic CRUD operations, 
* learning where Hibernate helps,
* learning where Hibernate can confuse us.
```
The goal is not just to memorize annotations.
The goal is to understand what is happening between Java objects and database tables.
```
### A very small preview

```java
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

}
```

This class can be mapped to a database table.

Later, Hibernate can use this mapping to store and retrieve Student objects.

### Summary
Hibernate is an ORM framework for Java
ORM connects Java objects with relational database tables
JPA is the standard, Hibernate is an implementation
Hibernate reduces repetitive database code
Hibernate does not replace SQL knowledge
For a modern new project, Hibernate 7.3 is the right version to start with today (2026)