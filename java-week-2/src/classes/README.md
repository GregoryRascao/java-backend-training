# 📘 Java Classes – Complete Reference

---

## 🔹 What is a Class in Java?

* A **class** is a blueprint or template for creating objects.
* It defines **fields (attributes/variables)** and **methods (behavior)**.
* Objects are created from classes using the `new` keyword.

Example:

```java
class Car 
{
    String color;   // field
    int speed;      // field

    void drive() 
    {  // method
        System.out.println("Car is driving");
    }
}

public class Demo 
{
    public static void main(String[] args) 
    {
        Car myCar = new Car(); // create object
        myCar.color = "Red";
        myCar.drive();
    }
}
```

---

## 🔹 Class Syntax

```java
class ClassName 
{
    // Fields (variables)
    // Methods (functions)
    // Constructors
    // Blocks
}
```

---

## 🔹 Components of a Class

1. **Fields (Variables)**

    * Store the state of an object.
    * Types:

        * **Instance variables** – Unique for each object.
        * **Static variables** – Shared across all objects of the class.

   **Use when:** You need to represent object state (instance) or shared data (static).

---

2. **Methods**

    * Define the behavior of objects.
    * Types:

        * **Instance methods** – Work with individual objects.
        * **Static methods** – Belong to the class, not objects.

   **Use when:**

    * Use **instance methods** if behavior depends on object data.
    * Use **static methods** for utility/helper logic (e.g., `Math.sqrt()`).

---

3. **Constructors**

    * Special methods used to initialize objects.
    * Automatically called when you use `new`.

   **Use when:** You need controlled or parameterized initialization of objects.

---

4. **Blocks**

   *Special code blocks inside a class that execute automatically.*

    * **Instance Initialization Block `{ }`**

        * Runs **before every constructor call**, whenever a new object is created.
        * Useful for *common setup code* across multiple constructors.

      ```java
      class Example 
      {
          {
              System.out.println("Instance block executed");
          }
 
          Example() 
          {
              System.out.println("Constructor executed");
          }
      }
      ```

    * **Static Initialization Block `static { }`**

        * Runs **once**, when the class is first loaded into memory.
        * Useful for initializing **static variables** or expensive setup logic.

      ```java
      class Config 
      {
          static int MAX;
          static 
          {
              MAX = 100;  // initialize static variable
              System.out.println("Static block executed");
          }
      }
      ```

   **Use when:**

    * Use **instance blocks** if multiple constructors share the same initialization code.
    * Use **static blocks** for static variable initialization or one-time setup (e.g., loading config files, setting up drivers).

---

## 🔹 Types of Classes

1. **Regular Classes**

    * Basic user-defined classes.
    * **Use when:** You just need to model real-world entities.

2. **Abstract Classes**

    * Cannot be instantiated.
    * May contain abstract methods (no body).
    * **Use when:** You want a base class that enforces a contract but lets subclasses provide details.

3. **Final Classes**

    * Cannot be extended.
    * **Use when:** You want to prevent inheritance (e.g., `String` in Java).

4. **Inner Classes** – Classes inside another class.

   **Use when:**

    * Inner classes help logically group classes.
   

---

## 🔹 Inheritance

* A class can inherit fields & methods from another class using `extends`.

```java
class Animal 
{
    void eat() 
    { 
        System.out.println("Eating..."); 
    }
}

class Dog extends Animal 
{
    void bark() 
    { 
        System.out.println("Barking..."); 
    }
}
```

**Use when:** You want to reuse code and establish an **is-a relationship**.

---

## 🔹 Access Modifiers in Classes

* **public** – Accessible everywhere.
* **default** – Accessible only within the same package.
* **abstract** – Declares an abstract class.
* **final** – Class cannot be extended.

**Use when:**

* Choose modifiers based on **encapsulation** and desired visibility.

---

## 🔹 UML Representation (Simple)

```bash
+------------------+
|     ClassName    |
+------------------+
| - field1         |
| - field2         |
+------------------+
| + method1()      |
| + method2()      |
+------------------+
```
