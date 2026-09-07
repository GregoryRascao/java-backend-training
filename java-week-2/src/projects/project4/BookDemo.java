package projects.project4;

public class BookDemo {

    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", "J. K Rowling", 1996);
        Book b = new Book();
        harryPotter.printDetails();
        b.printDetails();
    }

}
