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

## Design-Your-Own Projects

These are described only in terms of what the system needs to do. There are no hints about
which classes to create, which collection types to use, or where to apply abstract classes
or interfaces — that's for you to figure out and justify.

6. **Ride-Sharing Dispatch System** 🚕

   * The platform supports several vehicle types (economy car, XL van, motorbike), and each
     one calculates its fare differently.
   * Drivers are either online or offline, and can only be matched with a rider while online.
   * A rider requests a trip with a pickup and a drop-off location; the system matches them
     with an available driver.
   * Every completed trip has a fare, a distance, and a rating left by the rider.
   * Features: request a trip, complete a trip, view a driver's trip history, calculate a
     driver's average rating.

---

7. **Restaurant Ordering System** 🍽️

   * A menu contains items from different categories (starters, mains, drinks, desserts),
     and some combinations of items get a combo discount.
   * A customer places an order containing multiple items; every order moves through stages
     (received, preparing, ready, served).
   * An item can be marked temporarily unavailable and should not be orderable while it is.
   * Features: place an order, update an order's stage, calculate an order's total price
     (accounting for discounts), show the kitchen the pending orders sorted by waiting time.

---

8. **Smart Home Automation System** 🏠

   * A home contains many devices (lights, thermostats, door locks, cameras) grouped into
     rooms, and each device type behaves differently (on/off, a numeric setting, a status
     report, ...).
   * A "scene" is a saved configuration that changes several devices at once (e.g. "Movie
     Night" dims the lights and locks the doors).
   * Features: add or remove a device from a room, activate a scene, list every device that
     is currently on, report which devices are consuming the most energy.

---

