/**
 * 1. Create a class Book (title, author, price) that implements Serializable.
 * 2. Create a Book object and serialize it to "book.ser".
 * 3. Deserialize it back and print its data.
 */

package serialization.exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise1
{
    static class Book implements Serializable{
        String title;
        String author;
        double price;

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public String getTitle(){
            return title;
        }
        public String getAuthor(){
            return author;
        }
        public double getPrice(){
            return price;
        }
    }
    public static void main(String[] args)
    {
        Book book = new Book("Java for dump", "Bora", 99.99 );

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            out.writeObject(book);
             System.out.println("Book serialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
                try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("book.ser"))) {
            Book loadedBook = (Book) in.readObject();

            System.out.println("Title: " + loadedBook.getTitle());
            System.out.println("Author: " + loadedBook.getAuthor());
            System.out.println("Price: " + loadedBook.getPrice());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}