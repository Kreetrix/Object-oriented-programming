package Task5;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();


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

    public void borrowBook(String title){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                books.remove(book);
                System.out.println("Book borrowed");
            }
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