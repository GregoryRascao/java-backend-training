---

1. **Zoo Management System** 🦁🐒🐧

    * Abstract class: `Animal` (method `makeSound()`).
    * Subclasses: `Lion`, `Monkey`, `Penguin`.
    * Store animals in a `List<Animal>` (demonstrating **polymorphism**).
    * Features: feed animals, display zoo inventory.

---

2. **Online Quiz System** ❓

   * Classes: `Question`, `ChoiceQuestion`, `TrueFalseQuestion`.
   * Store questions in a `List<Question>`.
   * Use **polymorphism**: `displayQuestion()` overridden in each subclass.
   * Features: ask questions, check answers, calculate score.
   
---

3. **Employee Management System** 🏢

   * Abstract class: `Employee` (fields: name, salary).
   * Subclasses: `Developer`, `Manager`.
   * Store employees in a `List<Employee>`.
   * Features: print payroll, give raises, list managers separately.

---

4. **Library of Movies (Movie Catalog)** 🎬

   * Classes: `Movie`, `Actor`, `Director`.
   * Store movies in a `Map<String, Movie>` (key = movie title).
   * Features: add movies, search by genre, list movies by actor.


---

5. **School Library Borrowing System** 🏫

* Classes: `Book`, `Student`, `Teacher`, `Loan`.
* A `Loan` **HAS-A Book and Member**.
* Use a `Map<Member, List<Book>>` to track who borrowed what.
* Features: borrow/return books, list borrowed books by member.

---

