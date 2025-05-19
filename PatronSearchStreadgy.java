
import java.util.List;

// Make sure Library and PatronSystem are imported or defined elsewhere
public interface PatronSearchStreadgy {
    List<PatronSystem> searchpatron(String query, LibraryMaintinance library);
}
