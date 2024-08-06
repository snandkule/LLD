package BookPackage;

public class DigitalBook implements IBook{
    private int id;
    private String name;
    private boolean isAvailable;

    public DigitalBook(int id, String bookName){
        this.id = id;
        this.name = bookName;
        this.isAvailable = true;
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

}
