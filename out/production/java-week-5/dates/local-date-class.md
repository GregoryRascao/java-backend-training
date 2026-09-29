## 📅 `LocalDate` class in java

`LocalDate` is a **date-only** class (no time or timezone) that represents a date in the ISO-8601 calendar system (e.g., `2025-10-08`).

You create instances with:

```java
LocalDate today = LocalDate.now();
LocalDate date = LocalDate.of(2025, 10, 8);
LocalDate parsed = LocalDate.parse("2025-10-08");
```

---

## 🧱 1. Static Factory Methods

| Method                                                  | Description                     | Example                                                                    |
|---------------------------------------------------------|---------------------------------|----------------------------------------------------------------------------|
| `now()`                                                 | Current date from system clock  | `LocalDate.now()` → `2025-10-08`                                           |
| `now(ZoneId zone)`                                      | Current date in given time zone | `LocalDate.now(ZoneId.of("Asia/Tokyo"))`                                   |
| `of(int year, int month, int dayOfMonth)`               | Create a date manually          | `LocalDate.of(2025, 10, 8)`                                                |
| `ofYearDay(int year, int dayOfYear)`                    | Create from year and day number | `LocalDate.ofYearDay(2025, 100)`                                           |
| `parse(CharSequence text)`                              | Parse ISO date string           | `LocalDate.parse("2025-10-08")`                                            |
| `parse(CharSequence text, DateTimeFormatter formatter)` | Parse with custom format        | `LocalDate.parse("08-10-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy"))` |

---

## 🕒 2. Getters (Extract Date Parts)

| Method            | Description                    | Example                             |
|-------------------|--------------------------------|-------------------------------------|
| `getYear()`       | Returns year                   | `date.getYear()` → `2025`           |
| `getMonth()`      | Returns `Month` enum           | `date.getMonth()` → `OCTOBER`       |
| `getMonthValue()` | Month as `int` (1–12)          | `date.getMonthValue()` → `10`       |
| `getDayOfMonth()` | Day of the month (1–31)        | `date.getDayOfMonth()` → `8`        |
| `getDayOfWeek()`  | Day of week (MONDAY–SUNDAY)    | `date.getDayOfWeek()` → `WEDNESDAY` |
| `getDayOfYear()`  | Day number in the year (1–365) | `date.getDayOfYear()` → `281`       |
| `lengthOfMonth()` | Number of days in this month   | `date.lengthOfMonth()` → `31`       |
| `lengthOfYear()`  | Number of days in year         | `date.lengthOfYear()` → `365`       |
| `isLeapYear()`    | Checks if leap year            | `date.isLeapYear()` → `false`       |

---

## ➕ 3. Date Arithmetic (Add / Subtract)

| Method                                  | Description               | Example                            |
|-----------------------------------------|---------------------------|------------------------------------|
| `plusDays(long days)`                   | Add days                  | `date.plusDays(5)`                 |
| `plusWeeks(long weeks)`                 | Add weeks                 | `date.plusWeeks(2)`                |
| `plusMonths(long months)`               | Add months                | `date.plusMonths(1)`               |
| `plusYears(long years)`                 | Add years                 | `date.plusYears(1)`                |
| `minusDays(long days)`                  | Subtract days             | `date.minusDays(3)`                |
| `minusWeeks(long weeks)`                | Subtract weeks            | `date.minusWeeks(1)`               |
| `minusMonths(long months)`              | Subtract months           | `date.minusMonths(2)`              |
| `minusYears(long years)`                | Subtract years            | `date.minusYears(5)`               |
| `plus(long amount, TemporalUnit unit)`  | Add using ChronoUnit      | `date.plus(10, ChronoUnit.DAYS)`   |
| `minus(long amount, TemporalUnit unit)` | Subtract using ChronoUnit | `date.minus(3, ChronoUnit.MONTHS)` |

---

## 🔁 4. With Methods (Modify Specific Fields)

| Method                            | Description        | Example                                          |
|-----------------------------------|--------------------|--------------------------------------------------|
| `withYear(int year)`              | Change year        | `date.withYear(2030)`                            |
| `withMonth(int month)`            | Change month       | `date.withMonth(12)`                             |
| `withDayOfMonth(int day)`         | Change day         | `date.withDayOfMonth(1)`                         |
| `withDayOfYear(int day)`          | Change day of year | `date.withDayOfYear(200)`                        |
| `with(TemporalAdjuster adjuster)` | Adjust using rules | `date.with(TemporalAdjusters.firstDayOfMonth())` |

---

## 🔍 5. Comparisons & Checks

| Method                       | Description                  | Example                                |
|------------------------------|------------------------------|----------------------------------------|
| `isBefore(LocalDate other)`  | Is this date before another? | `date.isBefore(otherDate)`             |
| `isAfter(LocalDate other)`   | Is this date after another?  | `date.isAfter(otherDate)`              |
| `isEqual(LocalDate other)`   | Same date?                   | `date.isEqual(otherDate)`              |
| `equals(Object obj)`         | Checks equality              | `date.equals(LocalDate.of(2025,10,8))` |
| `compareTo(LocalDate other)` | Returns int (-,0,+)          | `date.compareTo(otherDate)`            |

---

## 🧭 6. Other Useful Utilities

| Method                                | Description                        | Example                                                                 |
|---------------------------------------|------------------------------------|-------------------------------------------------------------------------|
| `toEpochDay()`                        | Convert to days since 1970-01-01   | `date.toEpochDay()`                                                     |
| `atStartOfDay()`                      | Convert to `LocalDateTime` (00:00) | `date.atStartOfDay()`                                                   |
| `atTime(int hour, int minute)`        | Combine with time                  | `date.atTime(14, 30)`                                                   |
| `format(DateTimeFormatter formatter)` | Format date                        | `date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))` → `08/10/2025` |

---


## 🧪 Quick Demo

```java
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo 
{
    public static void main(String[] args) 
    {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, 5, 15);

        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);
        System.out.println("Days lived: " + ChronoUnit.DAYS.between(birthday, today));
        System.out.println("Next birthday: " + birthday.withYear(today.getYear()).plusYears(1));
        System.out.println("Formatted: " + today.format(DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy")));
    }
}
```

---

