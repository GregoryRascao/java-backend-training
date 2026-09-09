# 🔒 Encapsulation in Java

Encapsulation is one of the **four pillars of Object-Oriented Programming (OOP)**.  
It means **hiding the internal state of a class** (its fields) and allowing controlled access through **methods** (getters, setters, and business logic).

👉 Think of it like a **capsule**: the medicine (data) is hidden inside, and you only access it in a safe way.

---

## ✨ Why Encapsulation?

- ✅ Protects data from being changed directly  
- ✅ Allows validation before updating fields  
- ✅ Makes code easier to maintain and extend  
- ✅ Provides a clear boundary between **internal implementation** and **external usage**  

---

## ✅ Example – BankAccount

```java
package encapsulation;

public class BankAccount 
{
    private String accountNumber;  // hidden (private)
    private double balance;        // hidden (private)

    // Constructor
    public BankAccount(String accountNumber, double balance) 
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter
    public double getBalance() 
    {
        return balance;
    }

    // Setter with validation
    public void setBalance(double balance) 
    {
        if (balance >= 0) 
        {
            this.balance = balance;
        } 
        else 
        {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Deposit method
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        } 
        else 
        {
            System.out.println("Deposit must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
````

---

## 🔎 Explanation

* Fields `accountNumber` and `balance` are **private** → cannot be accessed directly from outside.
* Controlled access is provided via **getter, setter, and business methods**.
* Validation ensures:

    * No negative deposits
    * No overdrafts (can’t withdraw more than balance)
    * Balance cannot be set to a negative value

---

## 📊 Direct Access vs Encapsulation

| Aspect          | Without Encapsulation             | With Encapsulation                     |
|-----------------|-----------------------------------|----------------------------------------|
| Field access    | Direct (`account.balance = -100`) | Controlled (`account.setBalance(100)`) |
| Validation      | ❌ No validation possible          | ✅ Validation inside methods            |
| Security        | ❌ Fields exposed                  | ✅ Fields hidden (`private`)            |
| Maintainability | ❌ Harder to update logic          | ✅ Easy to add rules in one place       |

---

## 🎯 Learning Outcomes

By the end of this section, you should be able to:

* Declare fields as **private**
* Use **getters and setters** for controlled access
* Add **validation logic** inside methods
* Understand why encapsulation makes code **safer, cleaner, and more maintainable**

---

💡 **Best Practice:**

* Always keep fields **private**.
* Expose only what is necessary through **public methods**.
* Add **validation checks** in setters or business methods to maintain data integrity.

---
