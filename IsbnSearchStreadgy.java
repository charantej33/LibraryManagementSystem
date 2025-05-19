import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class IsbnSearchStreadgy implements BookSearchStreadgy {
    Logger logger = Logger.getLogger(IsbnSearchStreadgy.class.getName());
    @Override
    public List<BookManagement> searchbook(String query, LibraryMaintinance library) {
        List<BookManagement> result = new ArrayList<>();
        for (BookManagement book : library.getAllBooks()) {
            if (String.valueOf(book.getIsbn()).contains(query)) {
                result.add(book);
                logger.info("Book found: " + book.getTitle() + " by " + book.getAuthor());
                logger.info("ISBN: " + book.getIsbn());
                
            }
        }
        return result;
    }
}
