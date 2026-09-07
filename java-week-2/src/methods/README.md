# 📘 Java Methods – Complete Reference

This project demonstrates **all important aspects of methods in Java**, including **access modifiers, non-access modifiers,
return types, parameters, overloading, overriding, constructors, varargs, and the main method**.

---

## 🔹 What is a Method?

A **method** in Java is a block of code that performs a specific task.

* Methods help in **code reusability**, **organization**, and **abstraction**.
* Every method belongs to a **class** (no standalone functions in Java).

---

## 🔹 General Syntax

```java
modifier returnType methodName(parameters) 
{
    // method body
    return value; // if returnType is not void
}
```

### Breakdown:

1. **modifier** – Defines accessibility and behavior.

    * Access: `public`, `private`, `protected`, *default* (package-private).
    * Non-access: `static`, `final`, `abstract`, `synchronized`.

2. **returnType** – Type of value returned (`int`, `String`, `void`, etc.).

3. **methodName** – Descriptive name (camelCase convention).

4. **parameters** – Inputs to the method, enclosed in `()`.

5. **method body** – Block `{}` that contains logic.

---

## 🔹 Types of Methods

### 1. **User-defined methods**

Created by the programmer.

```java
public int square(int num) 
{
    return num * num;
}
```

### 2. **Predefined methods (built-in)**

Provided by Java libraries.

```java
public static void main(String[] args) 
{
    String s = "hello";
    System.out.println(s.length()); // length() is predefined
}
```

---

## 🔹 Access Modifiers in Methods

* **public** → accessible everywhere
* **protected** → accessible in the same package + subclasses
* **default (no modifier)** → accessible only within the same package
* **private** → accessible only within the class

Example:

```java
public void publicMethod() { }
protected void protectedMethod() { }
void defaultMethod() { }
private void privateMethod() { }
```

---

## 🔹 Non-Access Modifiers

* **static** → belongs to the class, not instances
* **final** → cannot be overridden
* **synchronized** → thread-safe method
* **abstract** → declared in abstract class, no body.

Example:

```java
public static void staticMethod() { }
public final void finalMethod() { }
public synchronized void syncMethod() { }
```

---

## 🔹 Return Types

* **`void`** → no return
* **primitive** → returns a value like `int`, `double`, etc.
* **object** → returns an object reference

Example:

```java
public void showMessage() { }
public int square(int n) { return n * n; }
public String greet(String name) { return "Hello, " + name; }
```

---

## 🔹 Parameters & Overloading

1. **Parameters**

```java
public void displayMessage(String msg) 
{
    System.out.println(msg);
}
```

2. **Method Overloading** → Same method name, different parameters

```java
public int add(int a, int b) { return a + b; }
public double add(double a, double b) { return a + b; }
```

---

## 🔹 Method Overriding

A subclass provides its own implementation of a superclass method.

```java
class Animal 
{
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal 
{
    @Override // annotation for clarity
    void sound() { System.out.println("Dog barks"); }
}
```

---

## 🔹 Varargs (Variable Arguments)

Allows passing **multiple values**.

```java
public void printNumbers(int... numbers) 
{
    for (int n : numbers) {
        System.out.print(n + " ");
    }
}
```

---

## 🔹 Special Methods

### 1. **main() method**

Entry point of Java applications.

```java
public static void main(String[] args) 
{
    System.out.println("Program starts");
}
```

### 2. **Constructor**

Special method used to initialize objects.

* Has the **same name as class**
* **No return type**

```java
public class Demo 
{
    public Demo() 
    {
        System.out.println("Constructor called");
    }
}
```

---

## 🔹 Method Signature

The **name + parameter list** defines the method signature.
⚠️ The **return type** is *not* part of the signature.

Example:

```java
public int add(int a, int b);   // signature: add(int, int)
public double add(double a, double b);   // signature: add(double, double)
```

---

## 🔹 Static vs Instance Methods

* **Static** → Called without creating an object.

```java
Methods.staticMethod();
```

* **Instance** → Requires an object.

```java
Methods obj = new Methods();
obj.instanceMethod();
```

---

## 🔹 Complete Example

```java
public class Methods 
{
    
    // Constructor
    public Methods() 
    {
        System.out.println("Constructor called.");
    }

    // Main method
    public static void main(String[] args)
    {
        Methods obj = new Methods();
        obj.instanceMethod();
        staticMethod();
        System.out.println("Sum: " + obj.add(3, 5));
        System.out.println("Sum: " + obj.add(2.5, 4.5));
        obj.printNumbers(1, 2, 3, 4, 5);
    }

    // Static method
    public static void staticMethod() 
    {
        System.out.println("Static method");
    }

    // Instance method
    public void instanceMethod() 
    {
        System.out.println("Instance method");
    }

    // Overloaded methods
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }

    // Varargs
    public void printNumbers(int... nums) 
    {
        for (int n : nums) System.out.print(n + " ");
        System.out.println();
    }
    
}
```

---

## ✅ Summary

* Methods make Java programs **modular** and **reusable**.
* They can be **static or instance-based**.
* Support **overloading** and **overriding**.
* Work with different **modifiers**, **parameters**, and **return types**.
* **main()** and **constructors** are special methods.
---

