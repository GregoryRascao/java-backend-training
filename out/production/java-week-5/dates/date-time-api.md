# Java Date and Time API

The modern date and time API lives in `java.time`. It replaces the old `Date` and `Calendar` classes.

---

## 1. LocalDate, LocalTime, LocalDateTime

```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
```

- `LocalDate`: date only.
- `LocalTime`: time only.
- `LocalDateTime`: date and time without timezone.

---

## 2. Period and Duration

```java
Period period = Period.between(LocalDate.of(2020, 1, 1), LocalDate.now());
Duration duration = Duration.between(LocalTime.of(9, 0), LocalTime.now());
```

- `Period` works with dates (years, months, days).
- `Duration` works with time (hours, minutes, seconds).

---

## 3. Formatting and Parsing

```java
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate parsed = LocalDate.parse("09/02/2026", fmt);
System.out.println(parsed.format(fmt));
```

---

## 4. Time Zones (Preview)

```java
ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
```

---

## Learning Outcomes

- Choose the correct date/time type for a task.
- Use `Period` and `Duration` to measure time.
- Format and parse dates with `DateTimeFormatter`.
