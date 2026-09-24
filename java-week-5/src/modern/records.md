# Records in Modern Java

## What is a Record?
Records are a special kind of class that:
- Are **immutable** by design
- Automatically provide implementations of `equals()`, `hashCode()`, and `toString()`
- Generate a canonical constructor based on the declared components
- Provide accessor methods for each component
- They reduce boilerplate code and make data modeling cleaner.

```java
public record Student(String name, int age) {}
```

With one line, Java automatically creates:

- a constructor
- accessor methods (`name()` and `age()`)
- `toString()`
- `equals()`
- `hashCode()`

---

## Why Use Records?

Use records when your class mainly stores data.

Good use cases:

- DTOs (Data Transfer Objects)
- API response models
- configuration data
- value objects

---

## Example

```java
record Book(String title, String author) {}

Book book = new Book("Clean Code", "Robert C. Martin");
System.out.println(book.title());
System.out.println(book);
```

## Key Features

### 1. Automatic Constructor
The canonical constructor is automatically generated based on the record components:

```java
public record Person(String name, int age) {}

// Usage
Person person = new Person("Alice", 30);
```

### 2. Accessor Methods
Accessor methods are automatically generated with the same name as the component:

```java
Person person = new Person("Alice", 30);
System.out.println(person.name());  // Alice
System.out.println(person.age());   // 30
```

### 3. Built-in Methods
Records automatically provide:
- `equals()`: Compares all components
- `hashCode()`: Based on all components
- `toString()`: Returns a string representation of all components

---

## Custom Validation

You can add validation by defining a custom canonical constructor:

```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
```

---

## Learning Outcomes

After this topic, students can:

- explain what records are
- create and use records
- access record components
- add basic constructor validation
