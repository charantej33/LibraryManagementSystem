import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class AuthorSearchStreadgy implements BookSearchStreadgy {
     private static final Logger logger = Logger.getLogger(AuthorSearchStreadgy.class.getName());
    @Override
    public List<BookManagement> searchbook(String query, LibraryMaintinance library) {
        List<BookManagement> result = new ArrayList<>();
        for (BookManagement book : library.getAllBooks()) {
            if (book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
                logger.info("Book found: " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        return result;
    }
    
}
