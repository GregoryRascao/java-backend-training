# 🧠 Serialization & Deserialization in Java

Serialization is a powerful Java mechanism that allows saving entire objects to files or sending them over networks -- a fundamental
concept for real-world applications like APIs, data persistence, and caching.

---

## 🔑 Key Concepts

### **1. What is Serialization?**

* **Serialization** is the process of **converting an object into a byte stream**.
* This byte stream can then be:

    * Saved to a file.
    * Sent over a network.
    * Stored in a database as binary data.

📘 Think of it as “freezing” an object’s state to store it for later.

---

### **2. What is Deserialization?**

* **Deserialization** is the reverse process -- it **reconstructs an object** from a saved byte stream.
* The object regains the same values for its fields as when it was serialized.

📘 Think of it as “unfreezing” an object and bringing it back to life.

---

### **3. Implementing Serializable**

To make a class serializable:

```java
class Person implements Serializable 
{
    private String name;
    private int age;
}
```

* The class must **implement `java.io.Serializable`** (a marker interface -- no methods).
* All fields inside the class must also be serializable.

---

### **4. Key Classes**

| Class                | Description                                                   |
|----------------------|---------------------------------------------------------------|
| `ObjectOutputStream` | Writes objects to an output stream (used for serialization)   |
| `ObjectInputStream`  | Reads objects from an input stream (used for deserialization) |
| `FileOutputStream`   | Writes bytes to a file                                        |
| `FileInputStream`    | Reads bytes from a file                                       |

---

### **5. Common Rules**

* The class and all its fields must implement `Serializable`.
* `transient` keyword → skips serialization of that field.
* Always **close streams** or use **try-with-resources**.
* Maintain a consistent class structure when deserializing.

---

## 🧠 Summary

- Serialization saves an object’s state to disk.
- Deserialization restores it.
- Requires `Serializable` interface.
- Use `ObjectOutputStream` and `ObjectInputStream`.
- `transient` fields are skipped.

---

## 🧩 Learning Outcomes

By completing this section, students will:

- Understand how **serialization** and **deserialization** work
- Use **ObjectOutputStream** and **ObjectInputStream** effectively
- Implement **Serializable** in custom classes
- Handle **transient** fields for security-sensitive data
- Work with **lists of serialized objects** in files

---

