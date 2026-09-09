# 📘 Constructors & Static in Java

---

## 🏗 Constructors

A **constructor** is a special method used to initialize objects.  

### 🔑 Key Points
- Must have the **same name** as the class.  
- Has **no return type** (not even `void`).  
- Runs **automatically** when an object is created.  

### ✨ Types of Constructors
1. **Default constructor** → automatically provided if no constructor is written.  
2. **Parameterized constructor** → accepts arguments to set initial values.  
3. **Constructor chaining** → one constructor calls another using `this()`.  

---

## ⚡ Static Members

- **Static field** → belongs to the *class*, not to individual objects.  
- **Static method** → can be called without creating an object.  
- Shared across all instances of the class.  

👉 Example: a counter that tracks how many objects have been created.  

---

## ✅ Example – Book with Multiple Constructors & Static Members

```java
package constructors;

public class Book 
{
    private static int counter = 0; // static field shared by all books
    private int id;
    private String title;
    private String author;

    public static void main(String[] args) 
    {
        Book b1 = new Book();
        Book b2 = new Book("1984");
        Book b3 = new Book("Animal Farm", "George Orwell");

        b1.printInfo();
        b2.printInfo();
        b3.printInfo();

        System.out.println("Total books created: " + Book.getBookCount());
    }

    // Default constructor
    public Book() 
    {
        this("Untitled", "Unknown"); // constructor chaining
    }

    // Parameterized constructor (title only)
    public Book(String title) 
    {
        this(title, "Unknown"); // chaining to another constructor
    }

    // Parameterized constructor (title + author)
    public Book(String title, String author) 
    {
        this.id = ++counter; // each new book gets a unique ID
        this.title = title;
        this.author = author;
    }

    // Instance method
    public void printInfo() 
    {
        System.out.println("Book #" + id + ": " + title + " by " + author);
    }

    // Static method
    public static int getBookCount() 
    {
        return counter;
    }
}
````

---

## 📊 Constructors vs Static Members

| Feature    | Constructors                      | Static Members                   |
|------------|-----------------------------------|----------------------------------|
| Purpose    | Initialize objects                | Belong to the class, not objects |
| Invocation | Runs when `new` object is created | Can be called without an object  |
| Scope      | Per object                        | Shared across all instances      |
| Example    | `Book("1984", "Orwell")`          | `Book.getBookCount()`            |

---

## 🎯 Learning Outcomes

* Differentiate between **default** and **parameterized** constructors
* Use **constructor chaining** with `this()` to avoid code duplication
* Understand how **static fields/methods** belong to the class rather than instances
* Track **shared state** across objects using `static` variables

---

💡 **Best Practice:**

* Use constructors for **object initialization**.
* Use `static` fields/methods only for **class-level behavior** (e.g., counters, utility methods).

---