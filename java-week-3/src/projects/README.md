# 📝 Projects ideas for Week 3

1. **Library Management System** 📚

    * Classes: `Library`, `Book`, `Member` (with `StudentMember`, `TeacherMember`).
    * Use **composition** (`Library HAS-A List<Book>`).
    * Store books in a `Map<ISBN, Book>`.
    * ISBN can be a String
    * Features: add/remove books, search by title, list members.
    * You can override equals and hashCode methods

---

2. **Banking Application** 💰

    * Classes: `BankAccount`, `CheckingAccount`, `SavingsAccount`.
    * Use **inheritance** for account types.
    * **Encapsulation** for balance (private + getters/setters).
    * Store accounts in a `Map<String, BankAccount>`.

---

3. **Student Management System** 🎓

    * Classes: `Student`, `Course`, `Teacher`.
    * A `Course` **HAS-A List<Student>`.
    * Store students in a `List<Student>`.
    * Features: enroll students, print course students.

---

4. **E-Commerce Shopping Cart** 🛒

    * Classes: `Product`, `Cart`, `User`.
    * Use `Map<Product, Integer>` for product quantities.
    * Features: add/remove products, calculate total price.
    
---

5. **Library of Music / Playlist Manager** 🎵

    * Classes: `Song`, `Playlist`, `Artist`.
    * A `Playlist` **HAS-A List<Song>`.
    * Use `List<String>`. check if the List contains a song before adding.
    * Features: add/remove songs, shuffle playlist.
    * You can override equals or hashCode

