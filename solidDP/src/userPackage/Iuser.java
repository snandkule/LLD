package userPackage;

import BookPackage.IBook;

import java.util.List;

public interface Iuser {
    public int getUserID();
    public String getUserName();
    public boolean canBorrow();
    public List<IBook> getBorrowedBooks();
    public void addBorrowedBook(IBook book);
    public void removeBorrowedBook(IBook book);
}
