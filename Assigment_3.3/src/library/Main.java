package library;

import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("Book 1", "Author 1", "10");
        Book book2 = new Book("Book 2", "Author 2", "20");
        Book book3 = new Book("Book 3", "Author 3", "30");

        LibraryMember libraryMember = new LibraryMember("Pekka");
        LibraryMember libraryMember2 = new LibraryMember("Miko");

        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(libraryMember);
        library.addMember(libraryMember2);

        library.borrowBook(libraryMember, book);

        library.reserveBook(libraryMember2, book2);
        library.displayReservedBooks(libraryMember2);

        library.cancelReservation(libraryMember2, book2);

        library.returnBook(libraryMember, book);



    }



}
