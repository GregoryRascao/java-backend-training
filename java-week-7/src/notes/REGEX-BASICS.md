# Regex Basics

> Optional reading  
> You do not need to fully master this yet.

This file introduces regex in a practical, beginner-friendly way.

---

## What is regex?

Regex means **regular expression**.

It is a pattern language for finding, matching, splitting, or replacing text.

Java often uses regex with methods such as:
```java
- `matches(...)`
- `replaceAll(...)`
- `split(...)`
```
---

## Why regex is useful

Real input is often messy.

Example input:

```text
INFO User logged in
WARN   Disk almost full
ERROR Crash detected

If you split only on one space, the second line may behave badly because it has multiple spaces.

```java
line.split(" ");
```

Better approach:

```java
line.split("\\s+");
```

Meaning:

\\s means whitespace

+ means one or more

So this works even if spacing is inconsistent.

---

## Basic regex symbols

| Pattern | Meaning |
|---|---|
| `.` | any single character |
| `\\d` | a digit |
| `\\D` | a non-digit |
| `\\s` | a whitespace character |
| `\\S` | a non-whitespace character |
| `\\w` | a word character |
| `+` | one or more of the previous pattern |
| `*` | zero or more of the previous pattern |
| `[abc]` | one character from the set |
| `[^abc]` | one character not in the set |
 
---

## Matching whole strings
+ means one or more

So this works even if spacing is inconsistent.
```java
 \s+
```
Basic regex symbols
Pattern	Meaning
.	any single character

- the line starts with `INFO`
- then any characters may follow
\\S	a non-whitespace character
---

## Character sets

```java
[aeiou]
```
*	zero or more of the previous pattern
[abc]	one character from the set
[^abc]	one character not in the set
```java
Matching whole strings
```

You can use matches(...) to check whether a whole string fits a pattern.

The `(?i)` part means case-insensitive.

---
## Check whether a string contains a vowel

```java
boolean hasVowel = text.matches("(?i).*[aeiou].*");

```
### Step by step:

(?i) means ignore case

.* means any characters before

[aeiou] means one vowel

.* means any characters after

So the full pattern means: somewhere in the text, there is at least one vowel.

This pattern works for both lowercase and uppercase vowels.

### Count vowels with replaceAll

```java
int count = text.replaceAll("(?i)[^aeiou]", "").length();

```
Read it step by step:

(?i) means ignore case

[^aeiou] means any character that is not a vowel

replaceAll(..., "") removes all non-vowels

length() counts the vowels that remain

Example:

```java
String city = "Antwerp";
String onlyVowels = city.replaceAll("(?i)[^aeiou]", "");
System.out.println(onlyVowels);

```
Output:

Ae

So the number of vowels is:

```java
int count = onlyVowels.length();
```
## Whitespace patterns

[^aeiou] means any character that is not a vowel

- tab (`\t`)
- newline (`\n`)

String city = "Antwerp";
String onlyVowels = city.replaceAll("(?i)[^aeiou]", "");
- `\\s` means one whitespace character
- `\\s+` means one or more whitespace characters
- `\\S` means one non-whitespace character
Whitespace patterns
### Replace repeated whitespace with one space



---

## Why do we write `\\s` in Java code?
tab (\t)

newline (\n)
- Java reads the string literal
- the regex engine reads the final pattern
\\s means one whitespace character

\\s+ means one or more whitespace characters
- `"\\s"` in Java becomes `\s` for regex
- `"\\d"` in Java becomes `\d` for regex
Replace repeated whitespace with one space
String cleaned = text.replaceAll("\\s+", " ").trim();

---

## Regex with streams
Why do we write \\s in Java code?

Because there are two layers:

Java reads the string literal

the regex engine reads the final pattern

So:

"\\s" in Java becomes \s for regex

"\\d" in Java becomes \d for regex

---

### Example
Map<String, Long> stats =
    lines.collect(Collectors.groupingBy(
        line -> line.trim().split("\\s+")[0],
        Collectors.counting()
    ));

splits by one or more whitespace characters

takes the first word

counts how many times that first word appears

trims each line

### Rule of Thumb

use regex when the text pattern is short and clear

prefer loops if the regex becomes hard to read
  
Regex is powerful, but do not overuse it.

use regex when the text pattern is short and clear

prefer loops if the regex becomes hard to read

Regex is a tool, not a goal.
