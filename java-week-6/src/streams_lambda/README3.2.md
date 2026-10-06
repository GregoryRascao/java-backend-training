# Streams and Lambda: Ordering, Uniqueness, and Comparison Rules

## Lesson Goal

In the previous lessons, we used:

- `sorted()`
- `distinct()`
- `max()`
- `min()`
- `Optional`

Now we will look at an important question:

**How does Java know when two objects are equal, or which object comes before another?**

By the end of this lesson, we should understand:

- how `max(...)` and `min(...)` decide which value wins
- the difference between `Comparable` and `Comparator`
- why `sorted()` works automatically for some types but not others
- how to sort objects using one or more fields
- how `thenComparing(...)` works
- how `distinct()` and `Set` decide whether two objects are the same
- the relationship between `equals()` and `hashCode()`
- a short reminder about Java's pass-by-value behavior

---

# Part 1: What Does "Greater" Mean?

With numbers, ordering feels obvious.

```java
List<Integer> numbers = List.of(10, 5, 20, 7);

int max = numbers.stream()
        .max(Integer::compareTo)
        .orElse(0);

System.out.println(max);
```

Output:

```text
20
```

But consider this:

```java
List<Student> students = ...
```

What is the "maximum" student?

Highest score?

Oldest student?

Alphabetically last name?

Java cannot decide this for us.

We have to provide the comparison rule.

This is the job of a `Comparator`.

---

# Part 2: How `max(...)` Uses a Comparator

Consider:

```java
List<Integer> scores = List.of(10, 44, 18, 44, 3);

Optional<Integer> maxScore = scores.stream()
        .max(Integer::compareTo);
```

The important part is:

```java
Integer::compareTo
```

This tells `max()` how two integers should be compared.

A comparator works roughly like this:

```text
negative number → first value comes before second
0               → values are equal for this ordering
positive number → first value comes after second
```

For example:

```java
Integer.compare(10, 20); // negative
Integer.compare(20, 10); // positive
Integer.compare(10, 10); // 0
```

`max()` keeps comparing elements and returns the greatest one according to this rule.

---

## Why Does `max()` Return Optional?

Because the stream might be empty.

```java
List<Integer> scores = List.of();
```

There is no maximum value.

So Java returns:

```java
Optional<Integer>
```

instead of returning `null`.

Example:

```java
List<Integer> scores = List.of(10, 44, 18, 44, 3);

int max = scores.stream()
        .max(Integer::compareTo)
        .orElse(0);

System.out.println(max);
```

Output:

```text
44
```

For an empty list:

```java
List<Integer> empty = List.of();

int max = empty.stream()
        .max(Integer::compareTo)
        .orElse(-1);

System.out.println(max);
```

Output:

```text
-1
```

We already know the Optional part from the previous lesson.

The new idea here is:

> `max()` does not know what "maximum" means until we give it a comparison rule.

---

# Part 3: Comparing Our Own Objects

Let's use a `Student` class.

```java
class Student {

    private final String name;
    private final int score;
    private final int age;
    private final String city;

    Student(String name, int score, int age, String city) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " (" + score + ", " + age + ", " + city + ")";
    }
}
```

And some students:

```java
List<Student> students = List.of(
        new Student("Amal", 85, 24, "Brussels"),
        new Student("Bram", 85, 22, "Antwerp"),
        new Student("Noa", 92, 22, "Brussels")
);
```

Now this question has no obvious answer:

```text
Which Student is greater?
```

Java needs a rule.

For example:

```java
Comparator<Student> byScore =
        Comparator.comparingInt(Student::getScore);
```

Now we can use it:

```java
Student bestStudent = students.stream()
        .max(byScore)
        .orElseThrow();

System.out.println(bestStudent);
```

Output:

```text
Noa (92, 22, Brussels)
```

---

# Part 4: Understanding `Comparator.comparing(...)`

This syntax may look strange at first:

```java
Comparator.comparingInt(Student::getScore)
```

Read it as:

> Compare students using their score.

The method reference:

```java
Student::getScore
```

is basically the shorter version of:

```java
student -> student.getScore()
```

So these express the same idea:

```java
Comparator.comparingInt(Student::getScore)
```

and:

```java
Comparator.comparingInt(student -> student.getScore())
```

The first version is usually cleaner.

---

# Part 5: `Comparable` vs `Comparator`

Java has two main ways to define ordering.

## `Comparable<T>`

`Comparable` defines the **natural/default order of the class itself**.

The class implements:

```java
Comparable<Student>
```

and provides:

```java
compareTo(Student other)
```

Example:

```java
class Student implements Comparable<Student> {

    private final String name;
    private final int score;

    // constructor + getters

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
```

Now we have declared:

> The natural order of students is alphabetical by name.

Because of that, this works:

```java
students.stream()
        .sorted()
        .forEach(System.out::println);
```

No comparator is needed.

---

## `Comparator<T>`

A `Comparator` defines an ordering **outside the class**.

Example:

```java
Comparator<Student> byScore =
        Comparator.comparingInt(Student::getScore);
```

Another one:

```java
Comparator<Student> byAge =
        Comparator.comparingInt(Student::getAge);
```

Another one:

```java
Comparator<Student> byName =
        Comparator.comparing(Student::getName);
```

The same class can therefore have many different ordering rules.

---

# Part 6: When Should We Use Which?

A useful way to think about it:

### `Comparable`

Use it when the class has one clear natural/default order.

Examples:

```text
Integer   → numeric order
String    → alphabetical/lexicographical order
LocalDate → chronological order
```

### `Comparator`

Use it when:

- there are multiple possible ways to sort
- the ordering depends on the situation
- you cannot modify the class
- you do not want ordering logic inside the class

For a `Student`, we might want:

```text
by name
by score
by age
by city
```

So `Comparator` is often more flexible.

---

# Part 7: Why Does `sorted()` Work for Integer and String?

This works:

```java
List<Integer> numbers = List.of(5, 2, 8, 1);

List<Integer> sorted = numbers.stream()
        .sorted()
        .toList();
```

And this works:

```java
List<String> names = List.of("Noa", "Amal", "Bram");

List<String> sorted = names.stream()
        .sorted()
        .toList();
```

Why?

Because `Integer` and `String` implement `Comparable`.

Java already knows their natural order.

---

# Part 8: `sorted()` with a Non-Comparable Class

Our `Student` class does not implement `Comparable<Student>`.

So:

```java
students.stream()
        .sorted()
        .toList();
```

compiles, but fails at runtime when Java tries to sort the objects.

You may get:

```text
ClassCastException
```

Java does not know how one `Student` should be compared with another.

We need to provide a comparator:

```java
List<Student> sorted = students.stream()
        .sorted(Comparator.comparingInt(Student::getScore))
        .toList();
```

Now Java knows the rule.

---

# Part 9: Different Comparators for the Same Class

We can define reusable comparators.

```java
class StudentComparators {

    static final Comparator<Student> BY_SCORE =
            Comparator.comparingInt(Student::getScore);

    static final Comparator<Student> BY_NAME =
            Comparator.comparing(Student::getName);

    static final Comparator<Student> BY_AGE =
            Comparator.comparingInt(Student::getAge);

    static final Comparator<Student> BY_CITY =
            Comparator.comparing(Student::getCity);
}
```

Then use whichever ordering we need.

```java
students.stream()
        .sorted(StudentComparators.BY_SCORE)
        .forEach(System.out::println);
```

Or:

```java
students.stream()
        .sorted(StudentComparators.BY_NAME)
        .forEach(System.out::println);
```

The objects did not change.

Only the ordering rule changed.

---

# Part 10: Ascending and Descending Order

By default:

```java
Comparator.comparingInt(Student::getScore)
```

sorts from low to high.

```text
70
80
90
```

To reverse it:

```java
Comparator.comparingInt(Student::getScore)
        .reversed();
```

Now:

```text
90
80
70
```

Example:

```java
List<Student> ranking = students.stream()
        .sorted(
                Comparator.comparingInt(Student::getScore)
                        .reversed()
        )
        .toList();
```

This gives us highest score first.

---

# Part 11: Be Careful with `max()` and `reversed()`

This is worth understanding.

Suppose:

```java
Comparator<Student> byScore =
        Comparator.comparingInt(Student::getScore);
```

Then:

```java
students.stream()
        .max(byScore)
```

returns the student with the highest score.

But if we write:

```java
Comparator<Student> byScoreDescending =
        Comparator.comparingInt(Student::getScore)
                .reversed();
```

then:

```java
students.stream()
        .max(byScoreDescending)
```

returns the student considered greatest according to the **reversed ordering**.

That means it may actually return the student with the lowest score.

So normally:

```java
max(Comparator.comparingInt(Student::getScore))
```

is clearer than:

```java
max(
    Comparator.comparingInt(Student::getScore)
              .reversed()
)
```

`reversed()` is especially useful for sorting.

---

# Part 12: What Happens When Two Values Are Equal?

Consider:

```java
List<Student> students = List.of(
        new Student("Amal", 85, 24, "Brussels"),
        new Student("Bram", 85, 22, "Antwerp"),
        new Student("Noa", 92, 22, "Brussels")
);
```

If we sort by score:

```java
students.stream()
        .sorted(Comparator.comparingInt(Student::getScore))
        .toList();
```

Amal and Bram both have:

```text
85
```

For our comparator, they are tied.

We can add another comparison rule to break the tie.

This is what `thenComparing()` does.

---

# Part 13: `thenComparing()`

Example:

```java
Comparator<Student> byScoreThenName =
        Comparator.comparingInt(Student::getScore)
                .thenComparing(Student::getName);
```

Read it as:

> Sort by score.  
> If two students have the same score, sort them by name.

Example:

```java
students.stream()
        .sorted(
                Comparator.comparingInt(Student::getScore)
                        .thenComparing(Student::getName)
        )
        .forEach(System.out::println);
```

You can keep chaining comparison rules.

```java
Comparator<Student> comparator =
        Comparator.comparing(Student::getCity)
                .thenComparingInt(Student::getAge)
                .thenComparing(Student::getName);
```

Read it as:

1. city
2. if city is the same, age
3. if age is also the same, name

---

# Part 14: `Comparator.naturalOrder()`

Sometimes you may see:

```java
Comparator.naturalOrder()
```

It simply means:

> Use the natural order defined by `Comparable`.

For strings:

```text
apple
banana
pear
```

For integers:

```text
1
2
3
```

Example:

```java
List<String> words =
        List.of("pear", "apple", "fig", "plum");

List<String> result = words.stream()
        .sorted(
                Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder())
        )
        .toList();
```

Output:

```text
[fig, pear, plum, apple]
```

Let's read it step by step.

First:

```java
Comparator.comparingInt(String::length)
```

means:

> Sort by length.

So conceptually:

```text
fig      3
pear     4
plum     4
apple    5
```

But `pear` and `plum` both have length `4`.

So:

```java
.thenComparing(Comparator.naturalOrder())
```

means:

> If lengths are equal, use the normal alphabetical ordering of the strings.

Therefore:

```text
pear
```

comes before:

```text
plum
```

---

# Part 15: Another Form of `thenComparing()`

Suppose we have:

```java
record Player(String name, int score) {}
```

We can write:

```java
Comparator<Player> ranking =
        Comparator.comparingInt(Player::score)
                .thenComparing(
                        Player::name,
                        Comparator.naturalOrder()
                );
```

This means:

> Compare score first.  
> If score is equal, get the player's name and compare those names using their natural order.

Because `String` already implements `Comparable`, we can shorten it to:

```java
Comparator<Player> ranking =
        Comparator.comparingInt(Player::score)
                .thenComparing(Player::name);
```

These express the same idea.

---

# Part 16: Comparison Is Not the Same as Equality

This distinction is very important.

A `Comparator` answers:

> In what order should these values appear?

`equals()` answers:

> Should these two objects be considered equal?

These are related concepts, but they are not the same thing.

For example:

```java
Student a = new Student("Amal", 85, 24, "Brussels");
Student b = new Student("Bram", 85, 22, "Antwerp");
```

A comparator using only score:

```java
Comparator<Student> byScore =
        Comparator.comparingInt(Student::getScore);
```

gives:

```java
byScore.compare(a, b); // 0
```

because both scores are `85`.

That does **not** mean:

```java
a.equals(b)
```

must be `true`.

It only means:

> According to this particular ordering rule, they are tied.

---

# Part 17: How Does `distinct()` Decide What Is a Duplicate?

We used:

```java
stream.distinct()
```

in the previous lesson.

For simple types this works naturally:

```java
List<String> names =
        List.of("Alice", "Bob", "Alice");

List<String> result = names.stream()
        .distinct()
        .toList();
```

Result:

```text
[Alice, Bob]
```

But what about our own objects?

```java
Student s1 =
        new Student("Amal", 85, 24, "Brussels");

Student s2 =
        new Student("Amal", 85, 24, "Brussels");
```

These contain exactly the same data.

But unless we define equality, Java normally treats them as two different objects.

So:

```java
List.of(s1, s2).stream()
        .distinct()
        .toList();
```

may still contain both.

To define what makes two students equal, we override:

```java
equals()
```

and:

```java
hashCode()
```

---

# Part 18: `equals()` and `hashCode()`

Suppose students should be considered equal when their name, score, age, and city are equal.

```java
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }

    if (!(o instanceof Student other)) {
        return false;
    }

    return score == other.score
            && age == other.age
            && Objects.equals(name, other.name)
            && Objects.equals(city, other.city);
}

@Override
public int hashCode() {
    return Objects.hash(name, score, age, city);
}
```

Now:

```java
Student s1 =
        new Student("Amal", 85, 24, "Brussels");

Student s2 =
        new Student("Amal", 85, 24, "Brussels");

System.out.println(s1.equals(s2));
```

prints:

```text
true
```

And:

```java
List<Student> unique =
        List.of(s1, s2).stream()
                .distinct()
                .toList();
```

contains only one student.

---

# Part 19: Why Do We Need `hashCode()` Too?

Collections such as:

```java
HashSet
HashMap
```

use hash codes to quickly find values.

The important rule is:

> If two objects are equal according to `equals()`, they must have the same `hashCode()`.

So when we override:

```java
equals()
```

we should normally also override:

```java
hashCode()
```

Otherwise hash-based collections may behave incorrectly.

---

# Part 20: How Does a `Set` Decide What Is Unique?

Example:

```java
Set<Student> students = new HashSet<>();

students.add(s1);
students.add(s2);
```

If `equals()` and `hashCode()` are properly implemented and `s1` and `s2` are equal, the set stores only one of them.

So:

```text
distinct()
HashSet
HashMap keys
```

all depend heavily on correct equality rules.

A useful mental model:

```text
Ordering:
Comparable / Comparator

Equality:
equals / hashCode
```

Do not mix these two responsibilities.

---

# Part 21: A Small Warning About Mutable Objects in HashSet

Suppose equality uses a student's name.

```java
hashCode()
```

is calculated partly from that name.

If we put the object into a `HashSet` and later change the name, its hash code may change.

The object may now be stored in the wrong internal location.

This can cause strange behavior such as:

```java
set.contains(student)
```

returning `false` even though the object is inside the set.

So fields used by:

```java
equals()
hashCode()
```

should ideally not change while an object is being used as a `HashSet` element or `HashMap` key.

---

# Part 22: Short Java Reminder — Java Is Pass by Value

This is not specifically a Stream feature, but it often causes confusion when working with objects and lambdas.

Java is always:

```text
pass by value
```

Consider:

```java
static void changeNumber(int number) {
    number = 100;
}

public static void main(String[] args) {
    int x = 10;

    changeNumber(x);

    System.out.println(x);
}
```

Output:

```text
10
```

The method received a copy of the value `10`.

Changing that copy does not change `x`.

---

# Part 23: What About Objects?

This is where people often say:

> Java passes objects by reference.

That is not quite correct.

Java passes the **reference by value**.

Example:

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
```

Now:

```java
static void changeName(Person person) {
    person.name = "Bob";
}
```

And:

```java
Person p = new Person("Alice");

changeName(p);

System.out.println(p.name);
```

Output:

```text
Bob
```

Why?

The method receives a copy of the reference.

Both references point to the same object.

```text
p ────────────────┐
                  ↓
              Person
             name="Alice"
                  ↑
person ───────────┘
```

So:

```java
person.name = "Bob";
```

changes the shared object.

---

# Part 24: Reassigning the Reference Is Different

Consider:

```java
static void replacePerson(Person person) {
    person = new Person("Charlie");
}
```

Then:

```java
Person p = new Person("Alice");

replacePerson(p);

System.out.println(p.name);
```

Output:

```text
Alice
```

Why?

The method only changed its local copy of the reference.

Conceptually:

```text
Before:

p -------> Alice
person --> Alice
```

Inside the method:

```text
p -------> Alice

person --> Charlie
```

`p` was never changed.

So the correct statement is:

> Java is always pass by value.  
> For objects, the value being copied is the reference.

---

# Part 25: Putting It Together

Imagine:

```java
List<Student> students = List.of(
        new Student("Amal", 85, 24, "Brussels"),
        new Student("Bram", 85, 22, "Antwerp"),
        new Student("Noa", 92, 22, "Brussels"),
        new Student("Amal", 85, 24, "Brussels")
);
```

We can remove duplicate students:

```java
List<Student> unique = students.stream()
        .distinct()
        .toList();
```

This depends on:

```text
equals()
hashCode()
```

We can sort them:

```java
List<Student> ranking = students.stream()
        .sorted(
                Comparator.comparingInt(Student::getScore)
                        .reversed()
                        .thenComparing(Student::getName)
        )
        .toList();
```

This depends on:

```text
Comparator
```

And we can find the highest scoring student:

```java
Student best = students.stream()
        .max(Comparator.comparingInt(Student::getScore))
        .orElseThrow();
```

Again, this depends on:

```text
Comparator
```

Different problem, different rule.

---

# Part 26: Common Pitfalls

### 1. Thinking `Comparator` defines equality

It does not.

```java
comparator.compare(a, b) == 0
```

means:

> These two values are tied according to this ordering.

It does not necessarily mean:

```java
a.equals(b)
```

---

### 2. Overriding `equals()` but not `hashCode()`

This can break:

```java
HashSet
HashMap
distinct()
```

Always think of them together:

```text
equals + hashCode
```

---

### 3. Calling `sorted()` on objects with no natural order

This may fail:

```java
students.stream()
        .sorted()
```

Either implement:

```java
Comparable<Student>
```

or provide:

```java
Comparator<Student>
```

---

### 4. Using `reversed()` incorrectly with `max()`

Remember:

```java
max(comparator)
```

returns the maximum according to **that comparator**.

Reversing the comparator also reverses what "maximum" means.

---

### 5. Forgetting that `max()` can have no result

This:

```java
stream.max(...)
```

returns an:

```java
Optional<T>
```

because the stream may be empty.

---

### 6. Assuming Java is pass by reference

Java is always:

```text
pass by value
```

For objects, the copied value happens to be a reference.

---

### 7. Changing fields used by `equals()` / `hashCode()`

Be careful when an object is already inside:

```java
HashSet
HashMap
```

Changing those fields may break lookup behavior.

---

# Exercise 1: Student Ranking

Given:

```java
List<Student> students = List.of(
        new Student("Amal", 85, 24, "Brussels"),
        new Student("Bram", 85, 22, "Antwerp"),
        new Student("Noa", 92, 22, "Brussels"),
        new Student("Sara", 92, 25, "Ghent")
);
```

Create a ranking with these rules:

1. highest score first
2. if scores are equal, youngest student first
3. if age is also equal, sort alphabetically by name

Hint:

```java
Comparator.comparingInt(...)
.reversed()
.thenComparingInt(...)
.thenComparing(...)
```

---

# Exercise 2: Find the Youngest Student

Use:

```java
min(...)
```

and an appropriate comparator.

Handle an empty list safely.

---

# Exercise 3: Find the Highest Scoring Student

Use:

```java
max(...)
```

with:

```java
Comparator.comparingInt(...)
```

Return a fallback or throw an exception if the list is empty.

---

# Exercise 4: Unique Students

Create two different `Student` objects containing the same information.

Add both to:

```java
HashSet<Student>
```

First try without overriding:

```java
equals()
hashCode()
```

Then implement them and try again.

Observe the difference.

---

# Key Ideas

There are two different questions.

## Equality

```text
Are these two objects considered the same?
```

Java uses:

```java
equals()
hashCode()
```

This matters for:

```text
HashSet
HashMap
distinct()
```

---

## Ordering

```text
Which value comes before or after another?
```

Java uses:

```java
Comparable
Comparator
```

This matters for:

```text
sorted()
max()
min()
```

---

A simple summary:

```text
equals() / hashCode()
        ↓
    uniqueness


Comparable / Comparator
        ↓
     ordering
```

And remember:

```text
Comparable
→ default/natural order of a type

Comparator
→ a specific ordering rule for a situation
```

Finally:

```text
Java is always pass by value.
For objects, the copied value is a reference.
```