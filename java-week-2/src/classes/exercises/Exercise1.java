package classes.exercises;

/**
 * Exercise 1: Basic Class
 * ------------------------
 * TODO:
 * 1. Create a class `Book` with fields: title, author.
 * 2. Add a method `displayInfo()` to print book details.
 * 3. Create objects in main() and call the method.
 */
public class Exercise1 {
    public static void main(String[] args) {
        Book book1 = new Book("Java for Newbies", "Bora");

        book1.displayInfo();
    }
}

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayInfo() {
        System.out.println("Title :" + title);
        System.out.println("author :" + author);
    }
}
