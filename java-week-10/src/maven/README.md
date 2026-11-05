# Maven & Project Structure

## What is Maven?

**Maven** is a **build automation and dependency management tool** used in Java projects.

In plain terms:
- It helps you **manage libraries** (no more downloading `.jar` files manually 🎉)
- It handles **compiling, packaging, testing**, and **running** your project automatically.
- It gives your project a **standard folder structure** that works everywhere.

---

### Why Developers Use Maven

| Problem Without Maven             | Solution With Maven                              |
|-----------------------------------|--------------------------------------------------|
| Manually download `.jar` files    | Maven automatically downloads them for you       |
| No standard project structure     | Maven enforces a clean, universal layout         |
| Hard to manage multiple libraries | Dependencies managed via `pom.xml`               |
| Complex build commands            | Simple: `mvn compile`, `mvn clean install`       |
| Hard to share projects            | Anyone can clone and run with just `mvn install` |

---

## Setting Up a Maven Project (Step-by-Step)

### In IntelliJ IDEA:

1. **File → New → Project → Maven**
2. Give it a name like `expense-tracker`
3. GroupId → `com.app`
4. ArtifactId → `expense-tracker`
5. Click **Finish**

---

### Maven Project Structure

Maven automatically creates this structure for you:

```

expense-tracker/
├── src/
│   ├── main/
│   │   ├── java/          # Java source code
│   │   └── resources/     # config.properties, JSON files, CSV files
│   └── test/
│       └── java/          # JUnit tests
├── pom.xml                # The heart of the project (dependencies + build info)
└── target/                # Compiled output (auto-generated)

````

### Maven Project Structure – Convention or Requirement?

You may wonder:

“Does Maven force this structure, or is it just a recommendation?”

**Short Answer**
 It is a convention, not a strict rule

### Convention over Configuration

Maven follows a principle called:

Convention over Configuration

This means:

If you follow the standard structure, you don’t need to configure anything

Maven will automatically know:
* where your source code is
* where your tests are
* where your resources are

### Default assumptions:

* src/main/java → application code
* src/test/java → test code
* src/main/resources → resource files

###️ Can we change it?

* **Yes**, you can override it in pom.xml

Example:
```xml
<build> <sourceDirectory>src/custom-java</sourceDirectory> </build>
```
Or for resources:
```xml
<build>
    <resources>
        <resource>
            <directory>src/config</directory>
        </resource>
    </resources>
</build>
```
## Should we change it?
 
In most cases: No

Why:

Breaks standard expectations
Makes projects harder to understand
Teams rely on this structure
### 🎯 Real-World Practice
99% of Maven projects use the default structure
Tools (IDE, CI/CD, plugins) expect this structure

### 💡 Takeaway

Maven does not force the structure,
but everything works best when you follow it.

👉 That’s why almost everyone uses the standard layout.

---

## Understanding `pom.xml`

The **Project Object Model (POM)** file defines your Maven project.

Example `pom.xml`:
```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.app</groupId>
  <artifactId>expense-tracker</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <!-- PostgreSQL JDBC Driver -->
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.3</version>
    </dependency>

    <!-- Gson for JSON handling -->
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.11.0</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>17</source>
          <target>17</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
````

**What happens next?**

* When you save this file, Maven **downloads** all dependencies automatically from the internet
into your local cache (`~/.m2` folder).
* You can then use those libraries in your code — no manual setup needed.

---

## Organizing Packages & Layers

Professional Java apps are divided into **layers** for clarity and maintainability.

Here’s the recommended structure you’ll use in Week 9 and 10:

```
src/main/java/com/app/
 ├── model/      → Holds data classes (e.g., Expense, User)
 ├── dao/        → Handles database logic (e.g., ExpenseDAO)
 ├── service/    → Business logic layer (e.g., ExpenseService)
 ├── util/       → Helper classes (e.g., DBUtil, JsonUtil)
 ├── App.java    → Main entry point
```

### 📘 Example

```java
// model/Expense.java
public class Expense {
    private int id;
    private String category;
    private double amount;
    private String date;
}
```

```java
// dao/ExpenseDAO.java
public class ExpenseDAO {
    public void addExpense(Expense expense) {
        // SQL INSERT logic here
    }
}
```

```java
// service/ExpenseService.java
public class ExpenseService {
    private ExpenseDAO dao = new ExpenseDAO();
    public void addExpense(Expense e) {
        dao.addExpense(e);
    }
}
```

```java
// App.java
public class App {
    public static void main(String[] args) {
        System.out.println("Expense Tracker Running...");
    }
}
```

---

## 🔗 Dependency Management in Maven

### Adding a new library

1. Find the library on [https://mvnrepository.com/](https://mvnrepository.com/)
2. Copy the `<dependency>` block
3. Paste it inside your `pom.xml` `<dependencies>` section
4. Maven will download and link it automatically

Example:

```xml
<dependency>
  <groupId>com.opencsv</groupId>
  <artifactId>opencsv</artifactId>
  <version>5.9</version>
</dependency>
```

---

## Common Maven Commands

| Command                                      | Description                                         |
|----------------------------------------------|-----------------------------------------------------|
| `mvn compile`                                | Compiles your Java source code                      |
| `mvn package`                                | Builds a `.jar` file in the `target/` folder        |
| `mvn clean`                                  | Deletes all compiled files                          |
| `mvn install`                                | Installs your project in the local Maven repository |
| `mvn test`                                   | Runs JUnit tests                                    |
| `mvn exec:java -Dexec.mainClass=com.app.App` | Runs your main class                                |

---

### Running Your Application with Maven

Maven is mainly a build tool, but we can also run our application using a plugin.

Step 1: Add exec plugin to pom.xml
```xml
<build>
  <plugins>
     <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.2.0</version>
        <configuration>
           <mainClass>org.hyf.school.Main</mainClass>
        </configuration>
     </plugin>
  </plugins>
</build>
```
Step 2: Run the application

mvn exec:java

### What happens?
* Maven compiles your code (if needed)
* Loads dependencies
* Runs your main() method

## Important

The mainClass must be your fully qualified class name:

✔ Correct:
org.hyf.school.Main

❌ Wrong:
main.java.org.hyf.school.Main

💡 Tip

You can also run without defining mainClass in the plugin:
```xml
mvn exec:java -Dexec.mainClass=org.hyf.school.Main
```

### Takeaway

Maven does not run code by default,
but plugins like exec-maven-plugin allow us to do it.

---

## Tools You’ll Use This Week

| Tool                  | Purpose                |
|-----------------------|------------------------|
| **PostgreSQL Driver** | Database connectivity  |
| **Gson**              | Read/write JSON files  |
| **OpenCSV**           | Export/import CSV data |
| **Commons DBCP2**     | Connection pooling     |
| **SLF4J Simple**      | Logging made easy      |
| **JUnit 5**           | Unit testing           |

---

## Final Goal of Week

By the end of this week, you should confidently be able to:

- Create and run Maven projects in IntelliJ
- Add dependencies and use them in your Java code
- Organize code into `model`, `dao`, `service`, and `util` layers
- Use JSON, CSV, and SQL data sources
- Build real-world Java apps using professional project structure

---
https://github.com/sammou00



