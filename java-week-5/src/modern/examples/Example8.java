/**
 * 1. Show the default equals/hashCode/toString behavior inherited from Object.
 * 2. Override equals, hashCode and toString to compare objects by value instead of reference.
 */

package modern.examples;

import java.util.Objects;

public class Example8
{




    public static void main(String[] args)
    {
        System.out.println("=== Without overrides (default Object behavior) ===");
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        b2.author += " ";
        System.out.println(b2.hashCode());

        System.out.println("b1: " + b1); // Book@<hash>, not helpful
        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2)); // false, compares references

        System.out.println();
        System.out.println("=== With overrides ===");
        BookWithOverrides c1 = new BookWithOverrides("Clean Code", "Robert C. Martin");
        BookWithOverrides c2 = new BookWithOverrides("Clean Code", "Robert C. Martin");

        System.out.println("c1: " + c1);
        System.out.println("c1 == c2: " + (c1 == c2));
        System.out.println("c1.equals(c2): " + c1.equals(c2)); // true, compares content
        System.out.println("c1.hashCode() == c2.hashCode(): " + (c1.hashCode() == c2.hashCode()));
    }
}
class Book
{
    private String title;
    public String author;

    Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }
}

class BookWithOverrides
{
    private String title;
    private String author;

    BookWithOverrides(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book{title='" + title + "', author='" + author + "'}";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof BookWithOverrides other))
        {
            //if we didn't return, we'd get a compilation error
            return false;
        }
        return title.equals(other.title) && author.equals(other.author);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(title, author);
    }
}