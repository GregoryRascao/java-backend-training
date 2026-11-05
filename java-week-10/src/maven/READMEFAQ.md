# FAQ – Maven Basics

## 1. What is Maven in simple terms?
Maven is a tool that:
- Downloads libraries (dependencies) for you
- Compiles your code
- Runs tests
- Packages your application (e.g., into a JAR)

** You write code + `pom.xml`, Maven does the rest.**

---

## 2. Why do we use Maven instead of downloading JAR files manually?
Without Maven:
- You download `.jar` files manually
- You manage versions yourself
- It becomes messy quickly

With Maven:
- You just add a dependency in `pom.xml`
- Maven downloads and manages everything automatically

---

## 3. What is `pom.xml`?
`pom.xml` is the **configuration file** of your project.

It defines:
- Project identity (`groupId`, `artifactId`, `version`)
- Dependencies (libraries)
- Build configuration

👉 Think of it as the “brain” of your project.

---

## 4. Where does Maven download dependencies?
Maven downloads dependencies to your **local repository**:


~/.m2/repository


👉 It downloads once and reuses them for all projects.

---

## 5. What is the purpose of the `target/` folder?
`target/` contains **generated files**:
- Compiled `.class` files
- Packaged `.jar` files

👉 It is safe to delete. Maven can recreate it anytime.

---

## 6. What happens when I run `mvn compile`?
Maven:
- Reads `pom.xml`
- Downloads dependencies (if needed)
- Compiles Java code from `src/main/java`
- Outputs `.class` files into `target/`

---

## 7. What happens when I run `mvn package`?
Maven:
- Compiles the code
- Runs tests
- Packages the project into a `.jar` (or `.war`)

👉 Output is created inside `target/`.

---

## 8. What is a dependency?
A dependency is an **external library** your project needs.

Example:
- PostgreSQL driver
- JSON library
- Logging library

👉 Added inside `<dependencies>` in `pom.xml`.

---

## 9. What is the standard Maven project structure?

* src/main/java → application code
* src/test/java → test code
* src/main/resources → config files
* target/ → generated output
* pom.xml → project configuration


---

## 10. What happens if I delete the `target/` folder?
Nothing breaks.

* Maven will recreate it the next time you run:
```
mvn compile
```

---

## 11. Can I run a Maven project on another computer easily?
Yes.

* As long as the project has `pom.xml`, Maven will:
- Download all dependencies
- Build the project

This makes projects **portable and reproducible**.

---


## 12. What is the difference between `src/main` and `src/test`?
- `src/main` → production code
- `src/test` → test code (JUnit, etc.)

👉 Maven treats them separately during build.

---

## 13. Why is Maven important in real projects?
Because:
- Teams need consistent builds
- Projects must run on different machines
- Dependency management must be reliable

👉 Maven solves all of these problems.

## 14. How do I set up my exercise projects
First, you need to create a folder for your projects.
Second, create one for each one of your projects. For example expanseTracker.
Then, put your previous code inside considering the file structure maven suggests.
Lastly, create your pom.xml inside and write it. You can copy from example pom.xml also.
