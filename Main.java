import java.util.*;
public class Main {
    public static void main(String[] args) {
        //creating the data management system
        Map<String, BookManagement> books = new HashMap<>();
        // Replace the arguments below with appropriate values
        PatronSystem patron = new PatronSystem("jhon", 1, +3-4907834);
        // Example usage to avoid 'never read' warning
        System.out.println(patron);
        List<BookLendingRecords> lendingRecords = new ArrayList<>();
        //adding books
        books.put("isbn0014", new BookManagement("Gravity by newton", "Issac newton", 14, 1998));
        books.put("isbn0016", new BookManagement("Zero by aryabhatta", "arya bhatta", 16, 1989));
      //adding patrons
        patron.addPatron("jhon", 11, 4907834);
        patron.addPatron("doe", 12, 4907835);
       //lending books
         // Assuming you want to lend the book "Gravity by newton" to patron "jhon"
         BookManagement book = books.get("isbn0014");
         java.time.LocalDate lendDate = java.time.LocalDate.now();
         java.time.LocalDate dueDate = lendDate.plusWeeks(2);
         BookLendingRecords record1 = new BookLendingRecords(book, patron, lendDate, dueDate);
          lendingRecords.add(record1);
        patron.recordBorrow("P001", record1);
        books.get("isbn0014").setStatus(BookStatus.BORROWED); 
        //returning books
       books.get("isbn0014").setStatus(BookStatus.AVAILABLE);
        //diplaying the books
         System.out.println("Books in Library:");
        for (BookManagement b : books.values()) {
            System.out.println("- " + b.getTitle() + " | " + b.getAuthor() + " | " + b.getStatus());
        }
        //displaying the patrons
        System.out.println("👤 Patrons:");
        patron.printAllPatrons();
        //displaying the lending records
          System.out.println("\n📖 Lending Records:");
        for (BookLendingRecords rec : lendingRecords) {
            System.out.println("- " + rec);
        }
        //displaying the borrowed books from the patron
         System.out.println("\n🧾 Borrow History for P001:");
        for (BookLendingRecords rec : patron.getBorrowHistory("P001")) {
            System.out.println("- " + rec.getBook() + " | Borrowed: " + rec.getStartDate() + " | Returned: " + rec.getEndDate()+"| patron: "+rec.getPatron().getPatronName());  
        }
    }
}