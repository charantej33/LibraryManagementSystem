import java.time.LocalDate;
import java.util.*;
import java .util.logging.Logger;
abstract class LibraryMaintinance implements BookSearchStreadgy, PatronSearchStreadgy {
    private static final Logger logger = Logger.getLogger(LibraryMaintinance.class.getName());
    private Map<String, BookManagement> books;
    private Map<String, BookManagement> isbnMap;
    private Map<String, PatronSystem> patronsname;
    private Map<Integer, PatronSystem> patronId;
    private List<BookLendingRecords> lendingRecords;
    

    public LibraryMaintinance() {
        books = new HashMap<>();
        isbnMap = new HashMap<>();
        patronsname = new HashMap<>();
        patronId = new HashMap<>();
        lendingRecords = new ArrayList<>();
    }
    // Add a new book to the library
    public void addBook(String title, String author, int isbn, int publicationYear) {
        BookManagement book = new BookManagement(title, author, isbn, publicationYear);
        books.put(title, book);
        isbnMap.put(String.valueOf(isbn), book);
        logger.info("Book added: " + title + " by " + author);
    }

    // remove a book from the library
    public void removeBook(String title) {
        BookManagement book = books.remove(title);
        if (book != null) {
            isbnMap.remove(String.valueOf(book.getIsbn()));
            logger.info("Book removed: " + title);
        }
    }
    public void removeBook(int isbn) {
        BookManagement book = isbnMap.remove(String.valueOf(isbn));
        if (book != null) {
            books.remove(book.getTitle());
            logger.info("Book removed: " + book.getTitle());
        }
    }
    // Add a new patron to the library
    public void addPatron(String name, int id, long phoneNumber) {
        PatronSystem patron = new PatronSystem(name, id, phoneNumber);
        patronsname.put(name, patron);
        patronId.put(id, patron);
        logger.info("Patron added: " + name);
    }
    // remove a patron from the library
    public void removePatron(int id, String name) {
        PatronSystem patronByName = patronsname.remove(name);
        // No need to remove from patronId using name, since patronId is keyed by Integer
        PatronSystem patronById = patronId.remove(id);
        if (patronById != null) {
            // Optionally, remove from patronsname as well if needed
            logger.info("Patron removed: " + name);
        }
    }
    //lending a book to a patron
    public void lendingbook(String bookTitle,int isbn, String patronName, LocalDate startDate, LocalDate endDate) {
        BookManagement book = TitleSearchStreadgy(bookTitle);
        BookManagement bookByIsbn = IsbnSearchStreadgy(isbn);
        PatronSystem patron = PatronSearchbyname(patronName);
        if (book != null && patron != null && bookByIsbn != null) {
            BookLendingRecords record = new BookLendingRecords(book, patron, startDate, endDate);
            lendingRecords.add(record);
            BookStatus status = BookStatus.BORROWED;
            book.setStatus(status);
            logger.info("Book " + book.getTitle() + " is lent to " + patron.getPatronName());
        } else {
            System.out.println("Book or Patron not found.");
        }
    }
    // returning a book
    public void returnBook(String bookTitle,int isbn, String patronName) {
        BookManagement book = TitleSearchStreadgy(bookTitle);
        BookManagement bookByIsbn = IsbnSearchStreadgy(isbn);
        PatronSystem patron = PatronSearchbyname(patronName);
        if (book != null && patron != null && bookByIsbn != null) {
            for (BookLendingRecords record : lendingRecords) {
                if (record.getBook().equals(book) && record.getPatron().equals(patron) && record.getBook().getIsbn() == isbn) {
                   BookStatus status = BookStatus.AVAILABLE;
                    book.setStatus(status);
                    lendingRecords.remove(record);
                    break;
                }
                logger.info("Book " + book.getTitle() + " is returned by " + patron.getPatronName());
            }
        } else {
            System.out.println("Book or Patron not found.");
        }
    }
    // print all books in the library
    public void printAllBooks() {
        System.out.println("Books in the library:");
        for (BookManagement book : books.values()) {
            logger.info("- " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear() + ", Status: " + book.getStatus() + ")");
        }
    }
    // print all patrons in the library
    public void printAllPatrons() {
        for (PatronSystem patron : patronsname.values()) {
            System.out.println("- " + patron.getPatronName() + " (ID: " + patron.getPatronId() + ", Phone: " + patron.getPhoneNumber() + ")");
            patron.printBorrowedBooks();
            logger.info("- " + patron.getPatronName() + " (ID: " + patron.getPatronId() + ", Phone: " + patron.getPhoneNumber() + ")");
        }
    }
    // search for a book by title
    public List<BookManagement> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    public BookManagement TitleSearchStreadgy(String title) {
        return books.get(title);
    }
    // Implement the missing IsbnSearchStreadgy method
    public BookManagement IsbnSearchStreadgy(int isbn) {
        return isbnMap.get(String.valueOf(isbn));
    }
//patron search by name
public List<PatronSystem> getAllPatrons() {
    return new ArrayList<>(patronsname.values());
}
public PatronSystem PatronSearchbyname(String name) {
    return patronsname.get(name);

}
}