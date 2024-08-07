package main.test.com.example.library;

import main.java.com.example.library.BookPackage.DigitalBook;
import main.java.com.example.library.BookPackage.PrintedBook;
import main.java.com.example.library.Library;
import main.java.com.example.library.userPackage.Iuser;
import main.java.com.example.library.userPackage.PremiumUser;
import main.java.com.example.library.userPackage.RegularUser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    Library library;
    @BeforeEach
    public void setUp(){
        library = new Library();
    }



    @Test
    public void testRegularUserBookBorrowLimit(){
        Iuser user1 = new RegularUser(1,"user1");
        for(int i=0;i<5;i++){
            library.borrowBook(user1, new PrintedBook(i,"book"+i, "location shelf 1"));
        }
        boolean exceptionThrown = false;
        try{
            library.borrowBook(user1, new PrintedBook(5,"book 5", "location shelf 1"));
        }catch(RuntimeException e){
            exceptionThrown=true;
        }
        Assertions.assertTrue(exceptionThrown, "Expected a RuntimeException to be thrown when exceeding borrow limit");
    }

    @Test
    public void testPrintedBookAvailability() {
        PrintedBook book = new PrintedBook(1, "Java Programming", "Shelf A");
        Assertions.assertTrue(book.isAvailable());

        book.setAvailability(false);
        Assertions.assertFalse(book.isAvailable());
    }

    @Test
    public void testEbookAvailability() {
        DigitalBook ebook = new DigitalBook(1, "Design Patterns");
        Assertions.assertTrue(ebook.isAvailable());

        ebook.setAvailability(false);
        Assertions.assertFalse(ebook.isAvailable());
    }

    @Test
    public void testRegularUserBorrowing() {
        RegularUser user = new RegularUser(1, "Alice");
        PrintedBook book = new PrintedBook(2, "Java Programming", "Shelf A");
//        Library library = new Library();
        library.borrowBook(user, book);
        Assertions.assertFalse(book.isAvailable());

        library.returnBook(user, book);
        Assertions.assertTrue(book.isAvailable());
    }

    @Test
    public void testPremiumUserBorrowing() {
        PremiumUser user = new PremiumUser(1, "Bob");
        DigitalBook book = new DigitalBook(1,"Effective Java");

//        Library library = new Library();
        library.borrowBook(user, book);
        Assertions.assertFalse(book.isAvailable());

        library.returnBook(user, book);
        Assertions.assertTrue(book.isAvailable());
    }

    @Test
    public void testUserBookOperations() {
        PrintedBook book = new PrintedBook(1, "Java Programming", "Shelf A");
        RegularUser user = new RegularUser(2, "Alice");

//        Library library = new Library();
        library.borrowBook(user, book);
        Assertions.assertFalse(book.isAvailable());

        library.returnBook(user, book);
        Assertions.assertTrue(book.isAvailable());
    }

    @Test
    public void testPremiumUserNoBorrowLimit() {
//        Library library = new Library();
        PremiumUser user = new PremiumUser(1, "Bob");
        for (int i = 0; i < 10; i++) {
            library.borrowBook(user, new PrintedBook(5,"book 5", "location shelf 1"));
        }
        // No limit for PremiumUser, so no exception should be thrown
    }

}
