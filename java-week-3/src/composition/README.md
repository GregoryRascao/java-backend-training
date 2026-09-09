# 🚗 Composition in Java

**Composition** is an important principle in object-oriented programming where a class is made up of one or more objects from other classes.  
It represents a **HAS-A relationship** (unlike inheritance, which represents an **IS-A relationship**).

---

## 🔑 Understanding Composition

👉 Examples:
- A `Car` **has an** `Engine`.
- A `Library` **has** `Books`.
- A `Computer` **has** a `Processor` and `Memory`.

---

## ✨ Why Use Composition?

- ✅ Promotes **code reuse** without tight coupling  
- ✅ More **flexible** than inheritance  
- ✅ Follows the design guideline: *“Favor composition over inheritance”*  
- ✅ Makes code easier to **maintain** and **extend**  

---

## ✅ Example – Car with Engine

```java
package composition;

// Engine class (component)
public class Engine 
{
    public void start() 
    {
        System.out.println("Engine started...");
    }
}

// Car class (composed of an Engine)
public class CarWithEngine 
{
    private Engine engine; // HAS-A relationship

    public CarWithEngine() 
    {
        this.engine = new Engine(); // Composition
    }

    public void startCar() 
    {
        engine.start(); // delegate to Engine
        System.out.println("Car is ready to go!");
    }

    // Demo
    public static void main(String[] args) 
    {
        CarWithEngine car = new CarWithEngine();
        car.startCar();
    }
}
````

---

## 📊 Composition vs Inheritance

| Feature           | Composition (HAS-A)                     | Inheritance (IS-A)              |
|-------------------|-----------------------------------------|---------------------------------|
| Relationship type | HAS-A                                   | IS-A                            |
| Flexibility       | High (can change components at runtime) | Less flexible (fixed hierarchy) |
| Code reuse        | Through delegation                      | Through extending base class    |
| Coupling          | Looser                                  | Tighter                         |
| Example           | Car **has an** Engine                   | Car **is a** Vehicle            |

---

## 🎯 Learning Outcomes

* Understand the difference between **IS-A (inheritance)** and **HAS-A (composition)**
* Learn how to implement relationships between classes using **object references**
* Apply **delegation** to share responsibilities between objects
* Recognize when to use **composition instead of inheritance** to keep designs flexible

---

💡 **Tip:** Use composition when:

* You want to **reuse behavior** from another class but don’t want to expose its full API.
* The relationship is naturally **HAS-A** (e.g., Car has Engine).
* You want to avoid **rigid inheritance hierarchies**.

---
