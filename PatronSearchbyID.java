import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class PatronSearchbyID implements PatronSearchStreadgy {
    private static final Logger logger=Logger.getLogger(PatronSearchbyID.class.getName());
    @Override
    public List<PatronSystem> searchpatron(String query, LibraryMaintinance library) {
        List<PatronSystem> result = new ArrayList<>();
        for (PatronSystem patron : library.getAllPatrons()) {
            if (String.valueOf(patron.getPatronId()).contains(query)) {
                result.add(patron);
                logger.info("Patron found: " + patron.getPatronName() + " with ID: " + patron.getPatronId());
            }
        }
        return result;
    }
    
}
