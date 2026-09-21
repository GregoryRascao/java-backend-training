package projects.project1;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author){
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty or null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be empty or null");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author cannot be empty or null");
        }
        
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    // TODO faire fonctionner le TODO
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Book other)) {
            return false;
        }

        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + isbn + ")";
    }
}
