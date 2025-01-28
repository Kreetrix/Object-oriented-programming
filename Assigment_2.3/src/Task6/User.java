package Task6;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> books = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void borrowed(Book book){
        this.books.add(book);
    }

    public void returned(Book book){
        this.books.remove(book);
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public ArrayList<Book> getBorrowedBooks() {
        return this.books;
    }
}
