import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
public class PatronSystem {
    private static final Logger logger = Logger.getLogger(PatronSystem.class.getName());
    private Map<String, List<BookLendingRecords>> PatronSystem = new HashMap<>();
    private Map<String, List<BookLendingRecords>> borrowHistory = new HashMap<>();
    private String patronName;
    private int patronId;
    private long patronPhoneNumber;
    private List<BookManagement> borrowedBooks;

    public PatronSystem(String patronName, int patronId, long   patronPhoneNumber) {
        this.patronName = patronName;
        this.patronId = patronId;
        this.patronPhoneNumber = patronPhoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }
    public void addPatron(String patronName, int patronId, long patronPhoneNumber) {
        PatronSystem.put(patronName, new ArrayList<>());
        logger.info("Patron added: " + patronName + " with ID: " + patronId);
    }
    // Getters
    public String getPatronName() {
        return patronName;
    }

    public int getPatronId() {
        return patronId;
    }

    public long  getPhoneNumber() {
        return patronPhoneNumber;
    }

    public List<BookManagement> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Setters
    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public void setPhoneNumber(long  patronPhoneNumber) {
        this.patronPhoneNumber = patronPhoneNumber;
    }

    // Business logic
    public void bookBorrowed(BookManagement book) {
        borrowedBooks.add(book);
    }

    public void bookReturned(BookManagement book) {
        borrowedBooks.remove(book);
    }
     public void printBorrowedBooks() {
        System.out.println("Books borrowed by " + patronName + ":");
        for (BookManagement book : borrowedBooks) {
           logger.info("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
    // Record keeping
    public void recordBorrow(String patronId, BookLendingRecords record) {
        if (borrowHistory.containsKey(patronId)) {
            borrowHistory.get(patronId).add(record);
            logger.info("Book borrowed by " + patronId + ": " + record.getBook().getTitle());
        } else {
            List<BookLendingRecords> records = new ArrayList<>();
            records.add(record);
            borrowHistory.put(patronId, records);
        }
    }
    //get all borrowed books
    public List<BookLendingRecords> getBorrowHistory(String patronId) {
        return borrowHistory.getOrDefault(patronId, new ArrayList<>());
    }
    public void printAllPatrons() {
        System.out.println("Patrons in the library:");
        for (String patronName : PatronSystem.keySet()) {
            System.out.println("- " + patronName);
            logger.info("- " + patronName);
        }
    }
}
