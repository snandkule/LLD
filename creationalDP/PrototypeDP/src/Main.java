public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello world!");

        ShapeRegistry registry = new ShapeRegistry();

        registry.addPrototype("big green circle", new Circle(10, "green"));
        registry.addPrototype("small red rectangle", new Rectangle(2, 3, "red"));

        Circle shape1 = ((Circle)registry.getPrototype("big green circle")).clone();
        Rectangle shape2 = ((Rectangle)registry.getPrototype("small red rectangle")).clone();

        shape1.setColor("blue");
        shape2.setHeight(5);

        System.out.println(shape1);
        System.out.println(shape2);
    }
}


//// shape -> clone method
//
//Circle -> radius, color
//Rectangle -> height, width, color
//
//ShapeFactory -> map of protytpe




