package Task6;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private String review;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author  = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.review = "";
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    public void addReview(String review){
        this.review = review;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public int getPublicationYear() {
        return this.publicationYear;
    }
}
