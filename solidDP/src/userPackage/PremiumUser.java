package userPackage;

import BookPackage.IBook;

import java.util.ArrayList;
import java.util.List;

public class PremiumUser implements Iuser{
    private int id;
    private String name;
    private List<IBook> borrowedBooks;

    public PremiumUser(int id, String name){
        this.id = id;
        this.name = name;
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
        return true;
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
