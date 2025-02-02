package library.system;

import library.model.Book;
import library.model.LibraryMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Library {
    private List<Book> books = new ArrayList<>();
    static HashMap<LibraryMember, Book> members = new HashMap<>();

    public void addBook(Book book) {
        System.out.println("Book added : " + book.getTitle());
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        System.out.println("Member added : " + member.getName());
        members.put(member, null);
    }

    public void borrowBook(LibraryMember member, Book book) {
        System.out.println("Book borrowed : " + book.getTitle());
        members.put(member, book);
    }

    public void returnBook(LibraryMember member, Book book) {
        if(members.containsKey(member)) {
            members.remove(book);
            System.out.println("Book returned : " + book.getTitle());
        }

    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }
}