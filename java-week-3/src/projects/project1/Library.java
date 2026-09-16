package projects.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, Book> books = new HashMap<>();
    private final List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException(
                    "A book with this ISBN already exists.");
        }

        books.put(book.getIsbn(), book);
    }

    public Book removeBook(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }

        return books.remove(isbn);
    }

    public Book findBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if (members.contains(member)) {
            throw new IllegalArgumentException(
                    "This member is already registered.");
        }

        members.add(member);
    }

    public List<Member> listMembers() {
        return Collections.unmodifiableList(members);
    }
}