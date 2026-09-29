# Equality: equals, hashCode, toString

You have already been using these methods without writing them yourself. Every class in Java
extends `Object`, and `Object` already provides `toString()`, `equals()` and `hashCode()`.
The problem is that the default versions are rarely useful for your own classes. This topic
shows how to override them correctly.

---

## 1. `toString()` — Default vs Overridden

By default, `toString()` returns something like `Book@1b6d3586` (class name + hash code in hex).
That is why we always override it in our own classes:

```java
@Override
public String toString()
{
    return "Book{title='" + title + "', author='" + author + "'}";
}
```

You already did this in the Builder Pattern examples (`User`, `Product`) — now you know *why*
it was there.

---

## 2. `equals()` — Default vs Overridden

By default, `equals()` behaves exactly like `==`: it compares references, not content.

```java
Book b1 = new Book("Clean Code", "Robert C. Martin");
Book b2 = new Book("Clean Code", "Robert C. Martin");

b1 == b2;        // false, different objects in memory
b1.equals(b2);   // false too, unless we override equals()
```

To compare by value, override `equals()`:

```java
@Override
public boolean equals(Object obj)
{
    if (this == obj)
    {
        return true;
    }
    if (!(obj instanceof Book other))
    {
        return false;
    }
    return title.equals(other.title) && author.equals(other.author);
}
```
Example 8
`obj instanceof Book other` is a *pattern match*: if `obj` really is a `Book`, Java creates the
variable `other` for us, already cast to `Book`. Normally a pattern variable like `other` only
exists inside the branch where the match succeeded. Here the condition is negated (`!`), and that
branch always returns. So if execution ever reaches the line after the `if` block, the compiler
knows the pattern must have matched — otherwise the method would already have returned. That is
why `other` can still be used on the last line, even though it was declared inside an `if` whose
block is never entered in that case. This is called *flow scoping*, and it is exactly the
question raised by the `//TODO` comment next to this code in `Example8.java`.

---

## 3. `hashCode()` — The Contract

Every object in Java has a `hashCode()` method, inherited from `Object`. It simply returns one
`int` number meant to represent that object.

By default, this number is based on the object's *identity* — a value the JVM assigns when the
object is created — not on its field values. So two different `Book` objects with the exact same
`title` and `author` normally get two different hash codes, and changing a field afterwards does
not change the number either, because the default `hashCode()` never reads the fields at all.

This default number is often assumed to be "the memory address", but that is not quite right:
Java does not guarantee that, and the garbage collector can move an object in memory without
changing its hash code. The one thing we can rely on is that calling `hashCode()` on the same
object always gives the same number, during the same run of the program.

**The contract:** if `equals()` says two objects are equal, they must also return the same
`hashCode()`. Because of this, whenever we override `equals()`, we must also override
`hashCode()` — using the same fields:

```java
@Override
public int hashCode()
{
    return Objects.hash(title, author);
}
```

`Objects.hash(...)` (from `java.util.Objects`) combines several fields into one hash code, the
same way we would combine them by hand. Now two `BookWithOverrides` objects with the same
`title` and `author` always produce the same hash code, matching what `equals()` says.

> This is exactly what a **record** generates for us automatically. That is the real reason
> records save so much boilerplate: one line replaces `toString()`, `equals()` and `hashCode()`.

---

## 4. Where This Matters Next

Java uses `hashCode()` in hash-based collections such as `HashSet` and `HashMap` to find where
an object should be stored or searched for. It is useful anywhere objects need to be looked up
efficiently by their hash, not just in a `HashSet`. The next step — giving objects an *ordering*
instead of just an equality check, with `Comparable` and
`Comparator`, and using that ordering in `TreeSet`/`TreeMap`/`LinkedHashMap` — is covered in its
own module: see `src/orderedcollections/orderedcollections.md`.

---

## Learning Outcomes

After this topic, students should be able to:

- Explain why the default `equals()`, `hashCode()` and `toString()` are usually not enough
- Override `equals()`/`hashCode()` correctly and consistently, using `Objects` helpers
- Explain why records generate these three methods automatically
- Explain why `equals()`/`hashCode()` matter for `HashSet`/`HashMap`
