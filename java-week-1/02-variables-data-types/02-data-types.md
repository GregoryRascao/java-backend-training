# 🔢 Data Types in Java

Java is a **statically typed language** — you must declare the type of each variable.
Data types fall into two categories:

## 1. Primitive Data Types

These are the most basic types, built into the Java language.

| Data Type | Size   | Example Values                  |
|-----------|--------|---------------------------------|
| `byte`    | 8-bit  | -128 to 127                     |
| `short`   | 16-bit | -32,768 to 32,767               |
| `int`     | 32-bit | -2,147,483,648 to 2,147,483,647 |
| `long`    | 64-bit | Large whole numbers             |
| `float`   | 32-bit | 3.14f, 2.5f                     |
| `double`  | 64-bit | 3.14159, 2.71828                |
| `char`    | 16-bit | 'A', '9', '\$'                  |
| `boolean` | 1-bit  | true, false                     |

Example:

```java
int number = 42;
boolean isJavaFun = true;
char grade = 'A';
```

---

## 2. Reference Data Types

Reference types are objects that store **references (memory addresses)**.
Examples: `String`, arrays, user-defined classes.

```java
String greeting = "Hello, Java!";
int[] numbers = {1, 2, 3, 4, 5};
```
