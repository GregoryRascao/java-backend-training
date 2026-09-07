# ☕ Difference Between JVM, JDK, and JRE in Java

Java has several components that work together to run programs.  
The most commonly confused terms are **JVM**, **JDK**, and **JRE**. This guide explains their differences.

---

## 1. JVM (Java Virtual Machine)

**Definition:**  
JVM is an **engine that runs Java bytecode**. It provides a platform-independent way of executing Java programs.

**Key Points:**

- Converts **bytecode** into machine code for the operating system.
- Part of **JRE**.
- Responsible for **memory management, garbage collection, and security**.
- Platform-dependent (each OS has its own JVM).

**Example:**

```text
Write Java Code → Compile → Bytecode → JVM executes → Output
```

---

## 2. JRE (Java Runtime Environment)

**Definition:**
JRE is a **package that provides the libraries and JVM** required to run Java programs.

**Key Points:**

- Contains **JVM + core libraries** (like java.lang, java.util, etc.).
- Needed **only to run** Java programs, not to develop them.
- Does **not include compiler (javac)**.

**Use Case:**
If you only want to **run a Java program**, install JRE.

---

## 3. JDK (Java Development Kit)

**Definition:**
JDK is a **full-fledged software development kit** for Java developers.
It includes **JRE + development tools**.

**Key Points:**

- Contains **JRE + compiler (javac) + debugger + other tools**.
- Required for **writing, compiling, and debugging Java programs**.
- JDK → JRE → JVM hierarchy.

**Use Case:**
If you want to **develop Java applications**, install JDK.

---

## 🔍 Summary Table

| Feature    | JVM                  | JRE                      | JDK                      |
|------------|----------------------|--------------------------|--------------------------|
| Full Form  | Java Virtual Machine | Java Runtime Environment | Java Development Kit     |
| Purpose    | Runs Java bytecode   | Run Java programs        | Develop and run programs |
| Contains   | -                    | JVM + Libraries          | JRE + Compiler + Tools   |
| Needed for | Execution            | Execution                | Development + Execution  |
| Platform   | OS-specific          | OS-specific              | OS-specific              |

---

## 🚀 Key Takeaways

1. **JVM** executes Java bytecode.
2. **JRE** contains JVM + libraries to run Java programs.
3. **JDK** contains JRE + tools to develop Java programs.
4. If you want to **run**, install JRE; if you want to **develop**, install JDK.

---
