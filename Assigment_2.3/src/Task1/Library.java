package Task1;

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

    public void findBooksByAuthor(String author){
        for(Book book : books){
            if(book.getAuthor().equals(author)){
                System.out.printf("Task1.Book found by the author: %s year: %d", book.getTitle(), book.getPublicationYear());
            }
        }
    }
}