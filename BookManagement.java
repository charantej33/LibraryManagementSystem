public class BookManagement {
    private String bookTitle;
    private String authorName;
    private int isbn;
    private int publicationYear;
    private BookStatus status;

    public BookManagement(String bookTitle, String authorName,int isbn, int publicationYear) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
    }
// Getters
    public String getTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return authorName;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public BookStatus getStatus() {
        return status;
    }
     // Setters
    public void setTitle(String title) {
        this.bookTitle = title;
    }

    public void setAuthor(String author) {
        this.authorName = author;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
     // Status operations
    public void markBookAsCheckedOut() {
        this.status = BookStatus.CHECKED_OUT;
    }

    public void markBookAsReturned() {
        this.status = BookStatus.AVAILABLE;
    }

    public void markBookAsLost() {
        this.status = BookStatus.LOST;
    }

    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE;
    }
   
}