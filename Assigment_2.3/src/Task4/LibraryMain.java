package Task4;

public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("No title", "Pekka", 1992);
        Book book2 = new Book("Literally 1984", "No author", 1984);
        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);

        library.displayBooks();
        library.findBooksByAuthor("Pekka");

    }
}
