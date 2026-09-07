# Control Structures, Modern Java (21+) & Design Notes

In this unit, we work with Java **control structures** (`if`, `switch`, loops),
while also getting a first look at **modern Java (21+)** features and
some **design principles (SRP, OCP)** that we will explore in more depth later.

This is not about advanced design yet — it is about learning to recognize
early signals.

---

## Running `.java` files directly (Java 11+)

Traditionally, Java programs were executed in two explicit steps:

```bash
javac HelloWorld.java
java HelloWorld
```
That means:

.java → .class (bytecode)

.class → executed by the JVM

## Modern Java approach (Java 11+)
For small examples and learning purposes, Java can now do this in one step:

java --source 21 HelloWorld.java

## What happens behind the scenes?
Java does not skip compilation. Instead, it performs these steps automatically:

the .java file is compiled temporarily

a .class file is created in memory

the bytecode is executed immediately

no .class file is written to disk

Java is still a compiled language — the compilation step is just implicit.

This approach is meant for learning, demos, and small examples.
Real projects still use javac, Maven, or Gradle.

## What does --source mean?
```bash
java --source 21 HelloWorld.java
```
--source 21 tells Java:

“Compile and run this code using Java 21 language rules.”

This affects:

language syntax (e.g. var, modern switch)

compile-time rules

It does not change the runtime behavior of the JVM.

Important rule
The --source version cannot be higher than the installed JDK version.

If you are using JDK 21:
```bash
java --source 21 HelloWorld.java   # works
java --source 11 HelloWorld.java   # works
java --source 25 HelloWorld.java   # does NOT work with JDK 21
```

## Switch statements and design principles
switch is a fundamental Java control structure.
Used well, it is a helpful tool.
Used carelessly, it can become a design smell.

## SRP – Single Responsibility Principle

A class or method should have one reason to change.

Typical SRP problem with switch
```java
switch (operation) {
  case "+":
    result = a + b;
    log("addition");
    validate(a, b);
    break;
  case "-":
    result = a - b;
    log("subtraction");
    validate(a, b);
    break;
}
```
This switch:

* decides what to do
* performs the calculation
* logs information
* validates input


➡ Multiple responsibilities
➡ SRP is weakened

### Rule of thumb:
If case blocks start to grow, responsibilities are mixing.

## OCP – Open–Closed Principle

Software should be open for extension, but closed for modification.

Switch and OCP tension
```java
switch (operation) {
  case "+":
    return a + b;
  case "-":
    return a - b;
}
```
To add a new operation (*), you must:

modify the existing switch

➡ The code is not closed for modification
➡ Every new case is a potential source of bugs

### Key idea:

If adding a new behavior always requires editing old code,
OCP warning signs appear.

When is switch perfectly fine?
switch is a good choice when:

cases are small and stable

it is used for simple mapping

the set of values is fixed (e.g. enums)
```java
int days = switch (month) {
  case JAN, MAR, MAY -> 31;
  case APR, JUN -> 30;
  default -> 28;
};
```
Here:

behavior is simple and no growth is expected, there are no SRP or OCP issue.

Switch as a design signal (not a bug)
A switch becomes a design signal when:

the same switch logic appears in multiple places

case blocks become large and adding a new case affects many files, when we want to change our code, we have to do a shotgun surgery.

➡ Later in the course, we will replace such switches with
Strategy or State patterns.

### Key takeaway
A small switch is a tool.
A growing switch is a design signal.

### Project note (Calculator)
For the calculator project:

Use switch to select the operation

Keep each case short and focused

Handle invalid input and division by zero

Bonus: refactor your solution using a modern switch expression 
e.g. using yield, ->


## Text Blocks
```java
String message = """
Welcome!
Choose an option:
1 - Add
2 - Subtract
""";
```

### Is the value null
null means empty or blank.
```java
String name = getName(); // may return null
System.out.println(name.length()); // will be a problem
Optional<String> name = Optional.of("Bora");    
```

### Good to Know String operations
```java
String text = "Java";
text.isBlank();
text.lines();
text.repeat(3);
```
## Cognitive Complexity
Cognitive Complexity is a measure of how hard the control flow of a method is to understand. Methods with high Cognitive Complexity will be difficult to maintain.

## Java is old but not obsolete, modern but still disciplined