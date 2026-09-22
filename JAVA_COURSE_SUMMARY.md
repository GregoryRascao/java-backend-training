# Java Course Summary

This document is a study guide for the Java material currently available in this repository. It covers the first four weeks of the course and is designed to be used as a reference when reviewing a concept or debugging an exercise.

The best way to use this guide is to read a section, open the matching examples, and then solve the related exercise without looking at the solution.

## Course Progression

| Week | Main topics |
| --- | --- |
| 1 | Java setup, variables, data types, operators, conditions, loops, console input/output |
| 2 | Methods, parameters, arrays, `ArrayList`, classes, objects, constructors, introductory OOP |
| 3 | Encapsulation, inheritance, composition, polymorphism, collections, strings, object identity |
| 4 | Exceptions, interfaces, iterators, abstraction, and the first SOLID design principles |

---

## 1. Java Fundamentals

### 1.1 JDK, JRE, and JVM

Java source code is written in a `.java` file. The Java compiler transforms it into bytecode stored in a `.class` file. The JVM executes this bytecode.

```text
Source code (.java) -> javac -> Bytecode (.class) -> JVM -> Program output
```

- **JVM:** executes bytecode, manages memory, and performs garbage collection.
- **JRE:** contains the JVM and the libraries needed to run Java applications.
- **JDK:** contains the JRE and development tools such as the `javac` compiler.

A developer needs a JDK. An IDE helps with editing, running, debugging, and navigating a project, but the Java compiler and runtime are still the foundation.

### 1.2 The `main` method

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

- `public`: accessible to the JVM.
- `static`: callable without creating an object.
- `void`: returns no value.
- `String[] args`: command-line arguments.

A public class normally has the same name as its file, including capitalization.

---

## 2. Variables and Data Types

A variable has a name, a type, and a value.

```java
int age = 25;
double price = 19.99;
String name = "Alice";
final double TAX_RATE = 0.21;
```

Java is statically typed: a variable's type is known at compile time.

### 2.1 Primitive types

| Type | Purpose | Example |
| --- | --- | --- |
| `byte`, `short`, `int`, `long` | Whole numbers | `42`, `42L` |
| `float`, `double` | Decimal numbers | `3.14f`, `3.14` |
| `char` | One character | `'A'` |
| `boolean` | `true` or `false` | `true` |

Reference types represent objects, including `String`, arrays, collections, and your own classes.

```java
int score = 90;                // primitive
String message = "Well done"; // reference type
int[] scores = {90, 75, 82};  // reference type
```

Primitive variables cannot be `null`. A reference can be `null`, meaning it does not currently refer to an object.

### 2.2 Naming conventions

- Variables and methods use `camelCase`: `studentAge`.
- Classes use `PascalCase`: `StudentManager`.
- Constants use `UPPER_SNAKE_CASE`: `MAX_SIZE`.
- Names cannot start with a number or use a reserved keyword such as `class`.

### 2.3 Type conversion

Widening conversion happens automatically when the destination type can represent the source value safely:

```java
int number = 10;
double decimal = number; // 10.0
```

Narrowing conversion requires an explicit cast and can lose information:

```java
double value = 9.78;
int whole = (int) value; // 9
```

Narrowing can also cause overflow if the target type is too small. Text conversion uses parsing methods:

```java
int age = Integer.parseInt("25");
double amount = Double.parseDouble("19.95");
String text = String.valueOf(age);
```

Invalid text causes `NumberFormatException`.

---

## 3. Operators and Control Flow

### 3.1 Operators

- Arithmetic: `+`, `-`, `*`, `/`, `%`
- Assignment: `=`, `+=`, `-=`, `*=`, `/=`, `%=`
- Comparison: `==`, `!=`, `>`, `<`, `>=`, `<=`
- Logical: `&&`, `||`, `!`
- Unary: `++`, `--`, unary `+`, unary `-`
- Ternary: `condition ? valueIfTrue : valueIfFalse`

Integer division discards the decimal part: `5 / 2` produces `2`. Use `5 / 2.0` to obtain `2.5`. The remainder operator is useful for checks such as `number % 2 == 0`.

`&&` and `||` use short-circuit evaluation. Java may skip the right-hand expression when the result is already known.

### 3.2 Conditions

```java
if (score >= 80) {
    System.out.println("A");
} else if (score >= 60) {
    System.out.println("B");
} else {
    System.out.println("Keep practicing");
}
```

Use `switch` when one expression is compared with several known values:

```java
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

In a classic `switch`, forgetting `break` causes fall-through into the next case.

### 3.3 Loops

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

int count = 0;
while (count < 3) {
    count++;
}

do {
    count--;
} while (count > 0);
```

- Use `for` when the initialization, condition, and update are clear.
- Use `while` when repetition depends on a condition.
- Use `do-while` when the body must run at least once.
- `break` exits the nearest loop.
- `continue` skips the rest of the current iteration.

A variable declared inside a block is only visible inside that block.

---

## 4. Console Input and Output

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
System.out.print("Enter your age: ");
int age = scanner.nextInt();
scanner.nextLine();
String name = scanner.nextLine();
scanner.close();
```

- `print` writes without moving to a new line.
- `println` writes and moves to a new line.
- `printf` writes formatted output.
- `next()` reads one token.
- `nextLine()` reads the rest of the line.
- `nextInt()` and `nextDouble()` read numeric values.

A common problem is using `nextLine()` directly after `nextInt()`. The numeric method leaves the newline in the input buffer, so call `nextLine()` once to consume it.

Validate input with methods such as `hasNextInt()` and `hasNextDouble()` before reading. This prevents invalid user input from causing an unexpected exception.

The week 1 projects apply these concepts in calculators, guessing games, day finders, multiplication tables, grade calculators, and palindrome checkers.

---

## 5. Methods

A method groups a task behind a reusable name.

```java
public static int add(int first, int second) {
    return first + second;
}
```

A method contains a modifier, return type, name, parameters, and body. `void` means that it returns no value. A method signature contains the method name and parameter types; the return type is not part of the signature.

```java
int multiply(int a, int b) { return a * b; }
double multiply(double a, double b) { return a * b; }
```

This is **method overloading**: the same method name is used with different parameter lists.

Java passes arguments by value. When the argument is an object, the copied value is a reference to that object. Therefore, a method can change the object's state, but it cannot replace the caller's reference itself.

Varargs accept zero or more values:

```java
static int sum(int... numbers) {
    int total = 0;
    for (int number : numbers) {
        total += number;
    }
    return total;
}
```

Good methods have one clear responsibility, meaningful names, and explicit inputs and outputs.

---

## 6. Arrays and `ArrayList`

### 6.1 Arrays

An array stores values of one type at a fixed length. Indexes start at zero.

```java
int[] numbers = {10, 20, 30};
System.out.println(numbers[0]);
numbers[1] = 25;
System.out.println(numbers.length);
```

Accessing an invalid index throws `ArrayIndexOutOfBoundsException`.

```java
for (int number : numbers) {
    System.out.println(number);
}
```

Two-dimensional arrays are arrays of arrays:

```java
int[][] grid = {{1, 2}, {3, 4}};
for (int row = 0; row < grid.length; row++) {
    for (int column = 0; column < grid[row].length; column++) {
        System.out.println(grid[row][column]);
    }
}
```

Rows can have different lengths; this is a jagged array. The `Arrays` utility class provides `sort`, `toString`, `equals`, `copyOf`, `fill`, and `binarySearch`. Binary search requires sorted data.

### 6.2 Wrapper classes

Collections store objects rather than primitive values. Wrapper classes provide object versions of primitives:

| Primitive | Wrapper |
| --- | --- |
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Autoboxing converts a primitive to its wrapper automatically, and unboxing does the reverse.

### 6.3 `ArrayList`

`ArrayList` is a resizable, indexed collection.

```java
ArrayList<Integer> scores = new ArrayList<>();
scores.add(10);
int first = scores.get(0);
scores.set(0, 15);
System.out.println(scores.size());
```

Useful methods include `add`, `get`, `set`, `remove`, `contains`, `size`, and `isEmpty`.

With `ArrayList<Integer>`, `remove(1)` means remove the element at index 1. To remove the value 1, use `remove(Integer.valueOf(1))`.

---

## 7. Classes, Objects, and Constructors

A class is a blueprint containing fields and methods. An object is an instance of a class.

```java
class Student {
    String name;
    int age;

    void introduce() {
        System.out.println("I am " + name);
    }
}

Student student = new Student();
student.name = "Maya";
student.introduce();
```

Instance fields belong to one object. Static fields are shared by all objects of the class. Static methods do not have a current object, so they cannot directly access instance fields through `this`.

Constructors initialize objects. They have the class name and no return type:

```java
class Book {
    private final String title;

    Book(String title) {
        this.title = title;
    }
}
```

`this` refers to the current object. If no constructor is declared, Java supplies a no-argument constructor. After declaring a constructor, that automatic constructor is no longer supplied.

The main OOP ideas introduced here are:

1. **Encapsulation:** hide state and control access.
2. **Inheritance:** reuse and specialize a parent type.
3. **Polymorphism:** allow one type or method name to represent different behaviors.
4. **Abstraction:** expose the important behavior and hide implementation details.

---

## 8. Encapsulation and Access Modifiers

Encapsulation protects an object's internal state. Fields are usually private, and public methods expose safe operations.

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

Access levels:

| Modifier | Accessible from |
| --- | --- |
| `private` | The declaring class |
| no modifier | The same package |
| `protected` | The same package and subclasses |
| `public` | Any accessible class |

A business method such as `deposit` is often better than a public `setBalance`, because it can enforce rules such as positive deposits and no overdraft.

---

## 9. Inheritance, Polymorphism, and Composition

### 9.1 Inheritance

Inheritance describes an **IS-A** relationship.

```java
class Vehicle {
    protected String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void drive() {
        System.out.println("Vehicle is driving");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    @Override
    void drive() {
        System.out.println(brand + " car is driving");
    }
}
```

`super(...)` calls a parent constructor and must be the first statement in the child constructor. If the parent has no no-argument constructor, the child must call a matching parent constructor explicitly. `super.method()` can call the parent implementation.

Use inheritance only when the child truly satisfies the parent contract. Deep inheritance hierarchies create tight coupling.

### 9.2 Polymorphism

The declared type determines what the compiler allows. The actual object determines which overridden method runs at runtime.

```java
List<Vehicle> vehicles = List.of(new Car("Toyota"), new Bike("Trek"));
for (Vehicle vehicle : vehicles) {
    vehicle.drive();
}
```

A `Car` stored in a `Vehicle` variable is an example of safe upcasting. Downcasting should only be done after checking the actual type:

```java
if (vehicle instanceof Car car) {
    car.openTrunk();
}
```

Use `@Override` when redefining a parent method so the compiler can detect mistakes.

### 9.3 Composition

Composition describes a **HAS-A** relationship and often provides more flexibility than inheritance.

```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private final Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();
    }
}
```

The car uses an engine without being an engine. This is delegation: one object asks another object to perform part of the work.

---

## 10. Collections and Strings

### 10.1 Main collection types

```java
List<String> names = new ArrayList<>();
Set<String> tags = new HashSet<>();
Map<String, Integer> ages = new HashMap<>();
```

- `List`: ordered, indexed, and allows duplicates.
- `ArrayList`: common resizable `List` implementation.
- `Set`: stores unique values; `HashSet` does not guarantee order.
- `Map`: stores key-value pairs; keys are unique.

Prefer declaring variables using interfaces, such as `List`, and selecting an implementation such as `ArrayList`.

`List.of(...)` and `Map.of(...)` create immutable collections. They cannot be changed after creation.

When custom objects are stored in a `Set` or used as `Map` keys, `equals` and `hashCode` must be consistent. Equal objects must have the same hash code.

### 10.2 `String`, `StringBuilder`, and `StringBuffer`

`String` is immutable. Concatenating or replacing text creates another string. `StringBuilder` is mutable and efficient for repeated changes in one thread. `StringBuffer` is synchronized and is used when synchronized mutable text is specifically required.

```java
StringBuilder builder = new StringBuilder("Hello");
builder.append(" Java");
builder.reverse();
String result = builder.toString();
```

Use `.equals()` to compare object values. `==` compares references when used with objects.

```java
String first = new String("Java");
String second = new String("Java");
System.out.println(first.equals(second)); // true
System.out.println(first == second);      // false
```

String literals can share the string pool, and wrapper classes can cache common values. Therefore, `==` may appear to work in one example and fail in another. Use `.equals()` for values.

---

## 11. Errors and Exceptions

### 11.1 Three kinds of errors

- **Compilation errors:** detected before execution, such as invalid syntax or incompatible types.
- **Runtime errors:** occur while the program is running, often as exceptions.
- **Logical errors:** the program runs but produces an incorrect result.

### 11.2 Exception handling

```java
try {
    int number = Integer.parseInt(input);
    System.out.println(number);
} catch (NumberFormatException exception) {
    System.out.println("Please enter a valid integer.");
} finally {
    System.out.println("Cleanup happens here.");
}
```

- `try`: code that may fail.
- `catch`: handles an exception.
- `finally`: runs whether the operation succeeds or fails.
- `throw`: explicitly raises an exception.
- `throws`: declares that a method may pass an exception to its caller.

Checked exceptions, such as `IOException`, must be handled or declared. Unchecked exceptions extend `RuntimeException`, including `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`, and `NumberFormatException`.

Catch specific exceptions rather than always catching `Exception`. Catch child exception types before parent types. Avoid empty catch blocks.

### 11.3 Try-with-resources

Resources such as readers should be closed automatically:

```java
try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    System.out.println(reader.readLine());
} catch (IOException exception) {
    System.out.println("Could not read the file.");
}
```

Try-with-resources closes the resource even when an exception occurs.

Custom exceptions can represent meaningful domain rules by extending `Exception` or `RuntimeException`.

---

## 12. Interfaces and Abstract Classes

An interface is a contract or capability. A class can implement multiple interfaces.

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("The bird flies");
    }
}
```

Interfaces can contain abstract methods, `default` methods, `static` methods, and constants. A class implementing an interface must provide public implementations of its abstract methods.

Use an interface to describe what an object **can do**, such as `Flyable`, `Swimmable`, or `Soundable`. Use an abstract class to represent a shared base for closely related objects.

| Abstract class | Interface |
| --- | --- |
| A class can extend only one class | A class can implement several interfaces |
| Can have instance fields and constructors | Fields are constants by default and interfaces have no constructors |
| Good for shared state and implementation | Good for contracts and capabilities |

An abstract class cannot be instantiated. It can contain both normal methods and abstract methods that subclasses must implement.

---

## 13. Iterators

An enhanced `for` loop is ideal for reading collection elements:

```java
for (String name : names) {
    System.out.println(name);
}
```

Do not directly add or remove elements from a collection inside this loop. That can cause `ConcurrentModificationException`.

Use an `Iterator` when removal is part of the traversal:

```java
Iterator<String> iterator = names.iterator();
while (iterator.hasNext()) {
    String name = iterator.next();
    if (name.isBlank()) {
        iterator.remove();
    }
}
```

- `hasNext()` checks whether another element exists.
- `next()` returns the next element.
- `remove()` safely removes the element most recently returned by `next()`.

`remove()` must not be called before `next()`.

Maps can be traversed using `entrySet()`:

```java
for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## 14. SOLID Principles Covered So Far

### Single Responsibility Principle

A class should have one reason to change. A user service should not also send emails and generate reports. Separate responsibilities into separate classes.

### Open/Closed Principle

Software should be open for extension but closed for modification. For example, use a discount interface and create a new discount class instead of adding another branch to a large `if` statement.

### Dependency Inversion Principle

High-level code should depend on abstractions rather than concrete implementations.

```java
interface Engine {
    void run();
}

class Car {
    private final Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.run();
    }
}
```

The engine is injected from outside. This is dependency injection. It makes implementations replaceable and makes testing easier because a fake engine can be supplied.

These principles support separation of concerns, loose coupling, maintainability, and future testing.

---

## 15. Common Mistakes Checklist

1. Using `==` instead of `.equals()` for strings and object values.
2. Forgetting that integer division truncates the result.
3. Calling `nextLine()` after `nextInt()` without consuming the newline.
4. Reading an array outside the range `0` to `length - 1`.
5. Forgetting `break` in a classic `switch`.
6. Calling an instance member from a static context.
7. Making fields public instead of encapsulating them.
8. Downcasting without checking the actual type.
9. Modifying a collection directly during an enhanced `for` loop.
10. Catching a generic exception when a specific exception is available.
11. Using inheritance only for code reuse when the relationship is not truly IS-A.
12. Giving one class several unrelated responsibilities.

## 16. Final Learning Checklist

You should now be able to:

- Explain the roles of the JDK, JRE, and JVM.
- Declare variables and choose suitable primitive or reference types.
- Convert values safely and recognize possible overflow or precision loss.
- Use operators, conditions, loops, and console input/output.
- Write methods with parameters, return values, overloads, and varargs.
- Create and traverse arrays, two-dimensional arrays, and `ArrayList` objects.
- Create classes and objects and initialize them with constructors.
- Apply encapsulation with private fields and controlled methods.
- Explain inheritance, composition, upcasting, downcasting, and polymorphism.
- Choose between `List`, `Set`, and `Map`.
- Compare object values correctly with `.equals()`.
- Use `StringBuilder` when text changes repeatedly.
- Handle exceptions and close resources safely.
- Design interfaces as capabilities and distinguish them from abstract classes.
- Use iterators for safe removal during collection traversal.
- Recognize the first design problems described by SRP, OCP, and DIP.

## Related Repository Sections

- [Week 1 README](java-week-1/README.md)
- [Week 2 README](java-week-2/README.md)
- [Week 3 README](java-week-3/README.md)
- [Week 4 principles](java-week-4/info/principles.md)
