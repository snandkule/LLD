package userPackage;

import BookPackage.IBook;

import java.util.ArrayList;
import java.util.List;

public class RegularUser implements Iuser{
    private int id;
    private String name;
    private List<IBook> borrowedBooks;

    private final int MAX_NO_OF_BOOKS_BORROW_LIMIT = 5;
    private int currBooksBorrowCount;
    public RegularUser(int id, String name){
        this.id = id;
        this.name = name;
        this.currBooksBorrowCount = 0;
        this.borrowedBooks = new ArrayList<>();
    }
    @Override
    public int getUserID() {
        return id;
    }

    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public boolean canBorrow() {
    return currBooksBorrowCount< MAX_NO_OF_BOOKS_BORROW_LIMIT;
    }

    @Override
    public List<IBook> getBorrowedBooks(){
        return this.borrowedBooks;
    }

    @Override
    public void addBorrowedBook(IBook book){
        this.borrowedBooks.add(book);
    }

    @Override
    public void removeBorrowedBook(IBook book){
        this.borrowedBooks.remove(book);
    }
}
