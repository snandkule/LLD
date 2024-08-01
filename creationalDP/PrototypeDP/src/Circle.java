public class Circle implements Shape{
    private int radius;
    private String color;

    public Circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return this.radius;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle)super.clone();
    }

    @Override
    public String toString(){
        return "Circle: radius = "+ radius + ", color = "+color;
    }
}
