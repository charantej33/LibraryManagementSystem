import java.time.LocalDate;
import java.util.logging.Logger;
public class BookLendingRecords {
    private static final Logger logger = Logger.getLogger(BookLendingRecords.class.getName());
    private LocalDate startdate;
    private LocalDate enddate;
    BookManagement book;
    PatronSystem patron;
   public BookLendingRecords(BookManagement book, PatronSystem patron, LocalDate startdate, LocalDate enddate ) {
        this.book = book;
        this.patron = patron;
        this.startdate = startdate;
        this.enddate = enddate;
       
    }
      // Getters
    public LocalDate getStartDate() {
        return startdate;
    }

    public LocalDate getEndDate() {
        return enddate;
    }

    public BookManagement getBook() {
        return book;
    }

    public PatronSystem getPatron() {
        return patron;
    }
}
