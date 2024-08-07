package main.java.com.example.library.BookPackage;

public class PrintedBook implements IBook{
    private int id;
    private String name;
    private boolean isAvailable;
    private String location;

    public PrintedBook(int id, String bookName, String location){
        this.id = id;
        this.name = bookName;
        this.isAvailable = true;
        this.location = location;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setAvailability(boolean availability) {
        isAvailable = availability;
    }

    public String getLocation(){
        return location;
    }

}
