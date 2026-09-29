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

---

## 3. `hashCode()` — The Contract

Think of a `HashSet` as sorting objects into groups so it does not have to compare every
object with every other object. When you add a book, the set:

1. Calls `hashCode()` to find the group where the book should go.
2. Checks the books in that group with `equals()`.
3. Adds the book only if none of them is equal to it.

For example, if two `BookWithOverrides` objects have the same title and author,
`equals()` says they are equal. They must also have the same `hashCode()`, so the set
checks the same group and can find the existing book.

**The rule:** equal objects must have the same hash code. The reverse is not required:
different objects can have the same hash code. A hash code is a way to find a group,
not a unique ID; `equals()` makes the final decision.

If you override `equals()`, override `hashCode()` too. Otherwise, two equal objects may
be sent to different groups, and a `HashSet` may treat them as separate objects.

```java
@Override
public int hashCode()
{
    return Objects.hash(title, author);
}
```

`Objects.hash(...)` (from `java.util.Objects`) combines the fields used by `equals()`.
Use the same fields in both methods. `Objects.equals(a, b)` is also available when comparing
fields that might be `null`.

`hashCode()` is for finding objects efficiently in Java hash-based collections; it is not a
security hash. Its result is only a 32-bit value, so it is not suitable for protecting data,
checking file integrity, or storing passwords. Passwords need dedicated algorithms such as
Argon2, bcrypt or PBKDF2. There is a security connection, though: deliberately creating many
hash collisions can make some hash-table operations slow, a denial-of-service technique called
hash flooding.

> This is exactly what a **record** generates for you automatically. That is the real reason
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
