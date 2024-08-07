# Implementing the Prototype Design Pattern

You are tasked with creating a system for managing shapes in a graphic design application. The system should allow for creating new shapes by cloning existing ones. Implement the Prototype design pattern to provide a flexible solution for creating copies of shapes.

## Requirements

### Shape Interface
- Create a `Shape` interface with a method `Shape clone()`.

### Concrete Shape Classes
- Implement at least two classes that implement the `Shape` interface:
    - `Rectangle` with fields: `width`, `height`, `color`.
    - `Circle` with fields: `radius`, `color`.

### ShapeRegistry Class
- Create a `ShapeRegistry` class that stores and manages prototypes of different shapes.
- Provide methods to add prototypes to the registry and to retrieve cloned shapes from the registry:
    - `void addPrototype(String key, Shape prototype)`
    - `Shape getPrototype(String key)`

### Testing
- Create a test class `PrototypeTest` that demonstrates the use of the `ShapeRegistry` to clone different shapes and modify their properties.

## Example Usage

```java
public class main.java.com.example.library.Main {
    public static void main(String[] args) {
        ShapeRegistry registry = new ShapeRegistry();

        // Add prototypes to registry
        registry.addPrototype("big green circle", new Circle(10, "green"));
        registry.addPrototype("small red rectangle", new Rectangle(2, 3, "red"));

        // Clone shapes from registry
        Shape shape1 = registry.getPrototype("big green circle").clone();
        Shape shape2 = registry.getPrototype("small red rectangle").clone();

        // Modify cloned shapes
        ((Circle) shape1).setColor("blue");
        ((Rectangle) shape2).setHeight(5);

        System.out.println(shape1);
        System.out.println(shape2);
    }
}
