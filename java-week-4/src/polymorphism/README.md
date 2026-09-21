# 🦊 Polymorphism in Java

Polymorphism means **"many forms"**.  
It allows the same method name to behave differently depending on the **object type** or **method signature**.

---

## ✨ Types of Polymorphism

1. **Compile-time Polymorphism (Method Overloading)**
    - Same method name, but different parameter lists.
    - Decided at **compile time**.

2. **Runtime Polymorphism (Method Overriding)**
    - Subclass provides its own implementation of a method from the parent.
    - Decided at **runtime** (dynamic dispatch).

---

## ✅ Example – Animal Sounds

```java
package polymorphism;
// Parent class
public class Animal 
{
    public void makeSound() 
    {
        System.out.println("Some generic animal sound...");
    }
}

// Subclass Dog
class Dog extends Animal
{
    @Override
    public void makeSound() 
    {
        System.out.println("Woof Woof!");
    }
}
```

### 🔎 Explanation:

- The `Animal` class has a method `makeSound()`.
- The `Dog` class overrides this method to provide a specific sound.
- When we call `makeSound()` on an `Animal` reference that points to a `Dog` object, the `Dog`'s version is executed.

---

## 🎯 Learning Outcomes

- Differentiate between overloading and overriding
- Use the @Override annotation when redefining methods
- Apply runtime polymorphism with parent references (List<Animal>)
- Write flexible code that adapts to different object types

---
