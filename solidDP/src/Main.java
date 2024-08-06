import BookPackage.DigitalBook;
import BookPackage.IBook;
import BookPackage.PrintedBook;
import userPackage.Iuser;
import userPackage.PremiumUser;
import userPackage.RegularUser;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        IBook printedBook = new PrintedBook(1, "1984", "Aisle 3");
        IBook ebook = new DigitalBook(2, "Brave New World");

        // Add books to the library
        library.addBook(printedBook);
        library.addBook(ebook);

        // Create users
        Iuser regularUser = new RegularUser(1, "John Doe");
        Iuser premiumUser = new PremiumUser(2, "Jane Smith");

        // Add users to the library
        library.addUser(regularUser);
        library.addUser(premiumUser);

        // Borrow and return books
        library.borrowBook(regularUser, printedBook);
        library.borrowBook(premiumUser, ebook);

        System.out.println("Books borrowed by John Doe: " + regularUser.getBorrowedBooks().size());
        System.out.println("Books borrowed by Jane Smith: " + premiumUser.getBorrowedBooks().size());

        library.returnBook(regularUser, printedBook);
        library.returnBook(premiumUser, ebook);

        System.out.println("Books borrowed by John Doe after returning: " + regularUser.getBorrowedBooks().size());
        System.out.println("Books borrowed by Jane Smith after returning: " + premiumUser.getBorrowedBooks().size());
    }
}
