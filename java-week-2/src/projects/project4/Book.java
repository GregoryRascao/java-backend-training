package projects.project4;

public class Book {

    private String title;
    String author;
    Integer year;

    // default constructor, no-args constructor
    public Book() {
        title = "Empty Title";
        author = "";
        year = 0;
    }

    // parametrized constructor, all-args constructor
    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void printDetails() {
        System.out.printf("Title: %s, Author: %s, Year: %d\n", this.title, this.author, this.year);
    }

    public void setTitle(String title) {
        if(title == "") {
            System.out.println("Title is EMPTY!");
        }
        else if (title == null) {
            System.out.println("Null value has been passed to title");
            title = "Default title";
        }
        else {
            this.title = title;
        }
    }

    public String getTitle() {
        return this.title;
    }
}
