package library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    static int memberId;

    public LibraryMember(String name) {
        this.name = name;
        memberId++;
    }

    private List<Book> reservedBooks = new ArrayList<>();

    // Existing methods: getters, setters
    public void addReservedBook(Book book) {
        reservedBooks.add(book);
    }

    public void removeReservedBook(Book book) {
        reservedBooks.remove(book);
    }

    public boolean hasReservedBook(Book book) {
        return reservedBooks.contains(book);
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public String getName() {
        return this.name;
    }
}