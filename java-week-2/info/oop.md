# Object-Oriented Programming (OOP)

Java is an **Object-Oriented Programming (OOP)** language. OOP focuses on **objects** that combine **data** and **behavior**.
Java implements OOP principles to make programs **modular, reusable, and maintainable**.

---

## 1. Classes and Objects

### Class
A **class** is a blueprint or template for creating objects. It defines:
- **Attributes (fields)** → data of the object
- **Methods** → behavior/functions of the object

```java
class Car 
{
    String color;
    String model;
    int year;

    void start() 
    {
        System.out.println(model + " is starting.");
    }
}
````

### Object

An **object** is an instance of a class.

```java
public class Main 
{
    public static void main(String[] args) 
    {
        Car myCar = new Car(); // Object creation
        myCar.color = "Red";
        myCar.model = "Toyota";
        myCar.year = 2023;
        myCar.start();
    }
}
```

---

## 2. Four Main OOP Principles in Java

### 2.1 Encapsulation

**Encapsulation** is the practice of **hiding internal details** of an object and exposing only what is necessary.

* Achieved using **private fields** and **public getters/setters**.

```java
class Person 
{
    private String name;
    private int age;

    // Getter
    public String getName() 
    {
        return name;
    }

    // Setter
    public void setName(String name) 
    {
        this.name = name;
    }
}
```

---

### 2.2 Inheritance

**Inheritance** allows a class to **inherit properties and methods** from another class.

* The **superclass** is the parent class.
* The **subclass** is the child class.

```java
class Vehicle 
{
    void start() 
    {
        System.out.println("Vehicle is starting");
    }
}

class Bike extends Vehicle 
{
    void ringBell() 
    {
        System.out.println("Bike bell rings!");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Bike myBike = new Bike();
        myBike.start();   // Inherited from Vehicle
        myBike.ringBell(); // Own method
    }
}
```

---

### 2.3 Polymorphism

**Polymorphism** means **many forms**. In Java, it occurs in two types:

1. **Compile-time (Method Overloading)**: Same method name, different parameters.

```java
class Calculator 
{
    int add(int a, int b) 
    { 
        return a + b; 
    }
    double add(double a, double b) 
    { 
        return a + b; 
    }
}
```

2. **Runtime (Method Overriding)**: Subclass provides its own implementation.

```java
class Animal 
{
    void sound() 
    { 
        System.out.println("Animal sound"); 
    }
}

class Dog extends Animal 
{
    void sound() 
    { 
        System.out.println("Dog barks"); 
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Animal myDog = new Dog();
        myDog.sound(); // Dog barks
    }
}
```

---

### 2.4 Abstraction

**Abstraction** hides implementation details and shows only functionality.

* Achieved using **abstract classes** or **interfaces**.

```java
abstract class Shape 
{
    abstract void draw();
}

class Circle extends Shape 
{
    void draw() 
    {
        System.out.println("Drawing Circle");
    }
}
```

---

## 3. Additional OOP Features in Java

### 3.1 Interfaces

* Define **methods without implementation**.
* Classes **implement interfaces** and provide method definitions.

```java
interface Animal 
{
    void eat();
}

class Cat implements Animal 
{
    public void eat() 
    {
        System.out.println("Cat is eating");
    }
}
```

### 3.2 Constructors

* Special methods used to **initialize objects**.

```java
class Person 
{
    String name;
    Person(String name) 
    {
        this.name = name;
    }
}
```

### 3.3 `this` and `super` Keywords

* `this` → Refers to **current object**.
* `super` → Refers to **parent class**.

---

## 4. Advantages of OOP in Java

* **Modularity** → Code is organized into classes.
* **Reusability** → Use existing classes through inheritance.
* **Maintainability** → Easy to update or fix code.
* **Scalability** → Easier to add new functionality.

---

## 5. Summary Table of OOP Concepts

| Concept       | Description                                   | Example                      |
|---------------|-----------------------------------------------|------------------------------|
| Class         | Blueprint of an object                        | `class Car {}`               |
| Object        | Instance of a class                           | `Car myCar = new Car();`     |
| Encapsulation | Hiding data using private fields              | Getters/Setters              |
| Inheritance   | Subclass inherits from superclass             | `class Bike extends Vehicle` |
| Polymorphism  | One name, many forms (overloading/overriding) | `add()` method or `sound()`  |
| Abstraction   | Hiding implementation, exposing functionality | Abstract class / Interface   |

---

