# Generics in Java (Part 2)

In the previous lesson we learned:

Generic classes

Generic methods

Bounded type parameters

Type erasure basics

In this lesson we focus on wildcards and variance.

# 1. Why Wildcards Exist

Consider the following code:

```java
List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
// List<Number> nums = ints; // compile error
```
Even though Integer is a subtype of Number,
`List<Integer>` is not a subtype of `List<Number>`.

Why?

```java
// Imagine Java allowed this:
List<Number> nums = ints;
//then this would also be possible
nums.add(3.14);
```
Now ints would contain a Double, which breaks type safety.

Because of this, Java keeps generic types invariant.

Wildcards allow methods to accept different generic types safely,
without allowing operations that would break type safety.

# 2. Unbounded Wildcard List<?>

List<?> means:

A list of some unknown type

### Example:
```java
public static void printList(List<?> list)
{
    for (Object item : list)
    {
        System.out.println(item);
    }
}
```
Usage:
```java
printList(List.of("A", "B"));
printList(List.of(1, 2));
```
This works because the method does not care about the element type.

Important rule:

You can read elements as Object

You cannot add elements (except null)

Why?

Because Java does not know the exact type of the list.
because the exact element type is unknown.

### Another approach to understand the need to ?

```java
public static void printList(List<Object> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

List<String> names = List.of("Alice", "Bob");

// printList(names); // compile error

```
List<Object> does not mean "a list of anything".
It specifically means "a list whose element type is Object".

```java
public static void printList(List<?> list)
List<?> means "a list of some type; I don't need to know which type."

```
# 3. Upper Bound ? extends T

Sometimes we want to accept multiple related types.

### Example:
```java
public static double sumNumbers(List<? extends Number> numbers)
{
double sum = 0;

    for (Number n : numbers)
    {
        sum += n.doubleValue();
    }

    return sum;
}
```
This method accepts:
```java
List<Integer>
List<Double>
List<Float>
List<Number>
```
Because the element type is Number or a subtype of Number.

### Key rule:

Safe to read as Number

Not safe to add elements

Why?

Because the actual list might be `List<Integer>` or `List<Double>`,
Java cannot safely allow inserting values.

# 4. Lower Bound ? super T

Lower bounds are used when a method writes values into a collection.

### Example:
``java
public static void addDefaults(List<? super Integer> values)
{
    values.add(10);
    values.add(20);
}
```
This works for:
```java
List<Integer>
List<Number>
List<Object>
```
### Rule:

Safe to add Integer

Reading only guarantees Object


# 5. PECS Rule

A useful rule to remember:

## PECS
Producer → extends  (read)
Consumer → super    (write)

Example1.java
```java
public static <T> void copyElements(
        List<? extends T> source,
        List<? super T> destination)
{
    for (T item : source) {
        destination.add(item);
    }
}
```

Explanation:

source produces values → extends

destination consumes values → super

Producer and consumer are from the method's point of view.

### Quiz
```java

List<Integer> ints = List.of(1,2,3);
List<? extends Number> nums = ints;

Can we do nums.add(5)?
```

# 6. Choosing `<T>` vs Wildcards

Use `<T>` when:

The same type appears multiple times

You need a relationship between parameters

Why not use `<T>` everywhere?

Use a wildcard when the method does not need to refer to the type by name.

### Example:
```java
// I need to know the type because I return the same type
public static <T> T getFirst(List<T> list)
```
Use wildcards when:

The method only needs flexibility

The exact type is not important

### Example:
```java
// I don't care what the element type is
public static void printList(List<?> list)
```
### A better comparison
```java
public static <T> void moveFirst(
List<T> source,
List<T> destination)
```

T is required here because these two parameters must be related through the same type.

But with a wildcard:
```java
public static int size(List<?> list)
//we don't have to set up a type relationship.
```




### In summary
A type parameter (T) gives an unknown type a name.
A wildcard (?) represents an unknown type that we don't need to name.

```
? → unknown
? extends T → unknown, but at most T or a  subtype of T
? super T → unknown, but at least T  or a  supertype of T

```

# 7. Type Erasure Reminder

Generics mainly exist at compile time.

Generics exist mainly for compile-time type safety.

At runtime:
```java
List<String> words = new ArrayList<>();
List<Integer> numbers = new ArrayList<>();

System.out.println(words.getClass() == numbers.getClass()); // true
```

Both objects are simply:

    ArrayList

because generic type information is removed.

# 8. Common Generics Restrictions

Important limitations:

You cannot:
```java
new T()
new T[10]
List<int>
```
You should also avoid raw types:
```java
List list = new ArrayList(); // not recommended
```
Instead use:
```java
List<String> list = new ArrayList<>();
```

# 9. Common Mistakes

Use this quick checklist during class:

- Using `extends` and then trying to `add(...)`
- Using `super` and expecting precise read type instead of `Object`
- Using raw collections in new code
- Assuming generic type is available at runtime without `Class<T>` token

Suggested mini-assessment prompt:

"Write one method that only reads numeric values, one method that only writes integers, and one method that copies values between two lists safely. Explain each bound choice in one sentence."

# 10. Learning Outcomes

After this lesson you should be able to:

Read a generic method signature and explain it in plain language

Explain why List<Integer> is not a List<Number>

Use List<?>

Choose `extends` vs `super` without guessing

Use ? extends when reading values

Use ? super when writing values

Understand how generics behave at runtime

Refactor raw type code into typed generic code

Explain why runtime class checks do not preserve `List<String>` vs `List<Integer>`