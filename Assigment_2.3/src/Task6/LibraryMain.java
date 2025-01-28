package Task6;

public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("No title", "Pekka", 1992);
        Book book2 = new Book("Literally 1984", "No author", 1984);
        Library library = new Library();
        User user = new User("Miko", 30);

        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook("Literally 1984", user);

        library.getUsers();

        double average = library.getAverageBookRating();
        System.out.println(average);

        double best = library.getMostReviewedBook();
        System.out.println(best);

    }
}
