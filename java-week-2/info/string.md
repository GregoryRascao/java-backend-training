# Java String Class Methods

The `String` class in Java represents a sequence of characters. Below are commonly used `String` class methods with examples.

---

## 1. `char charAt(int index)`

Returns the character at the specified index.

```java
String str = "Hello";
char c = str.charAt(1); // 'e'
System.out.println(c);
```

---

## 2. `int length()`

Returns the length of the string.

```java
String str = "Hello";
int len = str.length(); // 5
System.out.println(len);
```

---

## 3. `boolean isEmpty()`

Checks if the string is empty.

```java
String str = "";
System.out.println(str.isEmpty()); // true
```

---

## 4. `String substring(int beginIndex)`

Returns a new string starting from `beginIndex` to the end.

```java
String str = "Hello";
System.out.println(str.substring(2)); // "llo"
```

---

## 5. `String substring(int beginIndex, int endIndex)`

Returns a new string from `beginIndex` to `endIndex - 1`.

```java
String str = "Hello";
System.out.println(str.substring(1, 4)); // "ell"
```

---

## 6. `boolean contains(CharSequence s)`

Checks if the string contains the specified sequence.

```java
String str = "Hello";
System.out.println(str.contains("ell")); // true
```

---

## 7. `boolean equals(Object anObject)`

Checks if two strings are equal.

```java
String str1 = "Hello";
String str2 = "Hello";
System.out.println(str1.equals(str2)); // true
```

---

## 8. `boolean equalsIgnoreCase(String anotherString)`

Checks equality ignoring case.

```java
String str1 = "hello";
String str2 = "HELLO";
System.out.println(str1.equalsIgnoreCase(str2)); // true
```

---

## 9. `String toLowerCase()`

Converts string to lowercase.

```java
String str = "HELLO";
System.out.println(str.toLowerCase()); // "hello"
```

---

## 10. `String toUpperCase()`

Converts string to uppercase.

```java
String str = "hello";
System.out.println(str.toUpperCase()); // "HELLO"
```

---

## 11. `String trim()`

Removes leading and trailing whitespace.

```java
String str = "  Hello  ";
System.out.println(str.trim()); // "Hello"
```

---

## 12. `String replace(char oldChar, char newChar)`

Replaces all occurrences of a character.

```java
String str = "Hello";
System.out.println(str.replace('l', 'p')); // "Heppo"
```

---

## 13. `String replace(CharSequence target, CharSequence replacement)`

Replaces a sequence of characters.

```java
String str = "Hello World";
System.out.println(str.replace("World", "Java")); // "Hello Java"
```

---

## 14. `String[] split(String regex)`

Splits string into an array based on regex.

```java
String str = "apple,banana,orange";
String[] fruits = str.split(",");
for(String fruit : fruits) 
{
    System.out.println(fruit);
}
```

---

## 15. `boolean startsWith(String prefix)`

Checks if string starts with a prefix.

```java
String str = "Hello";
System.out.println(str.startsWith("He")); // true
```

---

## 16. `boolean endsWith(String suffix)`

Checks if string ends with a suffix.

```java
String str = "Hello";
System.out.println(str.endsWith("lo")); // true
```

---

## 17. `int indexOf(int ch)`

Returns the index of first occurrence of a character.

```java
String str = "Hello";
System.out.println(str.indexOf('l')); // 2
```

---

## 18. `int indexOf(int ch, int fromIndex)`

Returns the index of first occurrence starting from `fromIndex`.

```java
String str = "Hello";
System.out.println(str.indexOf('l', 3)); // 3
```

---

## 19. `int lastIndexOf(int ch)`

Returns the index of last occurrence of a character.

```java
String str = "Hello";
System.out.println(str.lastIndexOf('l')); // 3
```

---

## 20. `int lastIndexOf(int ch, int fromIndex)`

Returns the last occurrence of a character before `fromIndex`.

```java
String str = "Hello";
System.out.println(str.lastIndexOf('l', 2)); // 2
```

---

## 21. `boolean matches(String regex)`

Checks if the string matches the regex.

```java
String str = "abc123";
System.out.println(str.matches("[a-z]{3}[0-9]{3}")); // true
```

---

## 22. `String concat(String str)`

Concatenates two strings.

```java
String str1 = "Hello";
String str2 = " World";
System.out.println(str1.concat(str2)); // "Hello World"
```

---

## 23. `char[] toCharArray()`

Converts string to character array.

```java
String str = "Hello";
char[] chars = str.toCharArray();
for(char c : chars) 
{
    System.out.println(c);
}
```

---

## 24. `static String valueOf(...)`

Converts different types to string.

```java
int num = 123;
String str = String.valueOf(num);
System.out.println(str); // "123"
```

---

## 25. `String intern()`

Returns a canonical representation for the string.

```java
String str1 = new String("Hello");
String str2 = str1.intern();
System.out.println(str1 == str2); // false
```

---

