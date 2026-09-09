package composition.exmaples;

import java.util.ArrayList;
import java.util.List;

public class Example2
{
    public static void main(String[] args)
    {
        Library library = new Library();
        library.addBook(new Book("Java Basics"));
        library.addBook(new Book("Design Patterns"));
        library.addBook(new Book("Spring Boot Guide"));

        library.showBooks();
    }
}

// Book.java
class Book
{
    private final String title;

    public Book(String title)
    {
        this.title = title;
    }

    public String getTitle() {  return title;}

    public String toString() {
        return "Book: " + title;
    }

}

// Library.java
class Library
{
    private final List<Book> books; // HAS-A relationship

    public Library(){
        books = new ArrayList<>(); // Composition
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("Book : " + book);
        }
    }
}

