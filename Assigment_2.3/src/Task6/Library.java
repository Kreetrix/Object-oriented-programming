package Task6;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }


    public void displayBooks(){
        for(Book book : books){
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Year: " + book.getPublicationYear());

        }
    }

    public void borrowBook(String title, User user){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                books.remove(book);
                System.out.println("Book borrowed");
                user.borrowed(book);
                users.add(user);
                return;
            }
        }
    }

    public void getUsers(){
        for(User user : users){
            System.out.printf("User: %s Age: %d, Borrowed book(s): ", user.getName(), user.getAge());
            for (Book book : user.getBorrowedBooks()){
                System.out.printf("%s ", book.getTitle());
            }
            System.out.println();
        }
    }

    public void returnBook(Book book){
        books.add(book);
        System.out.println("Book returned");
    }

    public boolean isBookAvailable(String title){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating(){
        double average = 0;
        int amount = 1;
        for(Book book : books){
            amount++;
            average = book.getRating();
        }
        if (amount > 0) {
            return average / amount;
        }
        return average;
    }

    public double getMostReviewedBook(){
        double best = 0.0;
        for(Book score : books){
            if (score.getRating() > best) {
                best = score.getRating();
            }
        }
        return best;
    }


    public void findBooksByAuthor(String author){
        for(Book book : books){
            if(book.getAuthor().equals(author)){
                System.out.printf("Task1.Book found by the author: %s year: %d", book.getTitle(), book.getPublicationYear());
            }
        }
    }
}