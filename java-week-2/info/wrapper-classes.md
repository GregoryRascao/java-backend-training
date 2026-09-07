# Java Wrapper Classes for Primitive Data Types

In Java, **wrapper classes** are used to convert primitive data types into objects. They are part of the `java.lang` package.

| Primitive Type | Wrapper Class |
|----------------|---------------|
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |
| char           | Character     |
| boolean        | Boolean       |

---

## 1. `Byte` Class

Represents a `byte` value as an object.

**Important Methods:**

```java
byte b = 10;
Byte byteObj = Byte.valueOf(b); // Autoboxing alternative

// Conversion
String str = "127";
Byte b2 = Byte.parseByte(str); // returns byte value 127

// Min/Max
System.out.println(Byte.MIN_VALUE); // -128
System.out.println(Byte.MAX_VALUE); // 127
```

---

## 2. `Short` Class

Represents a `short` value as an object.

**Important Methods:**

```java
short s = 100;
Short shortObj = Short.valueOf(s);

// Parsing
String str = "3000";
short s2 = Short.parseShort(str);

// Min/Max
System.out.println(Short.MIN_VALUE); // -32768
System.out.println(Short.MAX_VALUE); // 32767
```

---

## 3. `Integer` Class

Represents an `int` value as an object.

**Important Methods:**

```java
int i = 50;
Integer intObj = Integer.valueOf(i);

// Parsing
String str = "123";
int i2 = Integer.parseInt(str);

// Min/Max
System.out.println(Integer.MIN_VALUE); // -2147483648
System.out.println(Integer.MAX_VALUE); // 2147483647

// Other useful methods
System.out.println(Integer.toBinaryString(10)); // "1010"
System.out.println(Integer.toHexString(255));   // "ff"
```

---

## 4. `Long` Class

Represents a `long` value as an object.

**Important Methods:**

```java
long l = 1000L;
Long longObj = Long.valueOf(l);

// Parsing
String str = "1000000";
long l2 = Long.parseLong(str);

// Min/Max
System.out.println(Long.MIN_VALUE); // -9223372036854775808
System.out.println(Long.MAX_VALUE); // 9223372036854775807
```

---

## 5. `Float` Class

Represents a `float` value as an object.

**Important Methods:**

```java
float f = 10.5f;
Float floatObj = Float.valueOf(f);

// Parsing
String str = "3.14";
float f2 = Float.parseFloat(str);

// Min/Max
System.out.println(Float.MIN_VALUE); // 1.4E-45
System.out.println(Float.MAX_VALUE); // 3.4028235E38
```

---

## 6. `Double` Class

Represents a `double` value as an object.

**Important Methods:**

```java
double d = 20.5;
Double doubleObj = Double.valueOf(d);

// Parsing
String str = "3.14159";
double d2 = Double.parseDouble(str);

// Min/Max
System.out.println(Double.MIN_VALUE); // 4.9E-324
System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
```

---

## 7. `Character` Class

Represents a `char` value as an object.

**Important Methods:**

```java
char c = 'A';
Character charObj = Character.valueOf(c);

// Character utility methods
System.out.println(Character.isLetter(c)); // true
System.out.println(Character.isDigit('1')); // true
System.out.println(Character.isUpperCase(c)); // true
System.out.println(Character.toLowerCase(c)); // 'a'
```

---

## 8. `Boolean` Class

Represents a `boolean` value as an object.

**Important Methods:**

```java
boolean b = true;
Boolean boolObj = Boolean.valueOf(b);

// Parsing
String str = "true";
boolean b2 = Boolean.parseBoolean(str);

// Utility
System.out.println(Boolean.TRUE);  // true
System.out.println(Boolean.FALSE); // false
```

---

### Notes:

1. Wrapper classes are **immutable**.
2. They support **autoboxing** and **unboxing**:

```java
Integer i = 10; // autoboxing
int j = i;      // unboxing
```

3. Useful for working with **collections** like `ArrayList` since collections cannot store primitive types directly.

---

