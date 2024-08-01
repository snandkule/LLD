public class Rectangle implements Shape{
    private int height;
    private int width;
    private String color;

    public Rectangle(int height, int width, String color){
        this.height = height;
        this.width = width;
        this.color = color;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return this.height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return this.width;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle)super.clone();
    }

    @Override
    public String toString(){
        return "Circle: height = "+ height + ", width = "+width+", color = "+color;
    }
}
