import BookPackage.IBook;
import userPackage.Iuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    List<IBook> books;
    List<Iuser> users;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<IBook> getBooks() {
        return books;
    }

    public void addBook(IBook book) {
        this.books.add(book);
    }

    public List<Iuser> getUsers() {
        return users;
    }

    public void addUser(Iuser user) {
        this.users.add(user);
    }

    public void borrowBook(Iuser user, IBook book) {
        if(!(user.canBorrow() && book.isAvailable())){
            throw new RuntimeException("Book can not be borrowed");
        }
        book.setAvailability(false);
        user.addBorrowedBook(book);
    }

    public void returnBook(Iuser user, IBook book) {
        if(book.isAvailable()){
            throw new RuntimeException("Book already returned");
        }
        user.removeBorrowedBook(book);
        book.setAvailability(true);

    }
}
