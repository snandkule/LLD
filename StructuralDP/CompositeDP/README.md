# Composite Pattern

The Composite Pattern is a structural design pattern that lets you compose objects into tree-like structures to represent part-whole hierarchies. This pattern allows clients to treat individual objects and compositions of objects uniformly. It’s particularly useful when you need to work with hierarchical collections of objects.

## Components

1. **Component**: An interface or abstract class defining the common interface for both leaf objects and composite objects.
2. **Leaf**: Represents leaf objects in the hierarchy. Leaf objects do not have any children.
3. **Composite**: Represents composite objects that can have children (which can be either leaf objects or other composites).

## UML Diagram

Here’s a textual representation of the UML diagram for the Composite Pattern:

```plaintext
+--------------------+
|    Component       |
+--------------------+
| + operation()      |
+--------------------+
          ^
          |
          |
+--------------------+     +--------------------+
|       Leaf         |     |     Composite      |
+--------------------+     +--------------------+
| + operation()      |     | + operation()      |
+--------------------+     | + add(Component)   |
                            | + remove(Component)|
                            | + getChild(int)    |
                            +--------------------+
```

## Java Example

Let’s use an example of a graphical system where you have shapes like `Circle` and `CompositeShape` (which can contain other shapes).

### 1. Component Interface

```java
// Component.java
public interface Component {
    void draw();
}
```

### 2. Leaf Class

```java
// Circle.java
public class Circle implements Component {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}
```

### 3. Composite Class

```java
// CompositeShape.java
import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void draw() {
        for (Component component : components) {
            component.draw();
        }
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Component getChild(int index) {
        return components.get(index);
    }
}
```

### 4. Client Code

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        // Create individual circles
        Component redCircle = new Circle("red");
        Component blueCircle = new Circle("blue");

        // Create a composite shape
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.add(redCircle);
        compositeShape.add(blueCircle);

        // Draw individual shapes
        System.out.println("Drawing individual shapes:");
        redCircle.draw();
        blueCircle.draw();

        // Draw composite shape
        System.out.println("\nDrawing composite shape:");
        compositeShape.draw();
    }
}
```

## Explanation

### Component Interface (`Component`)

The `Component` interface defines the common operations that both leaf objects and composite objects must implement. This interface ensures that all objects in the composition, whether they are individual objects or composites of objects, can be treated uniformly. For example, it might declare methods like `draw()` that are implemented by both leaf and composite classes.

### Leaf Class (`Circle`)

The `Circle` class implements the `Component` interface. It represents a leaf object in the hierarchy, meaning it does not have any children. This class provides the implementation for the operations defined in the `Component` interface, such as `draw()`. The `Circle` class encapsulates the details of an individual shape and handles its own specific behavior.

### Composite Class (`CompositeShape`)

The `CompositeShape` class also implements the `Component` interface but can contain other `Component` objects. It represents a composite object that can hold and manage child components, which can be either leaf objects or other composites. The `CompositeShape` class delegates the `draw()` operation to its children. It includes methods to add, remove, and retrieve child components, enabling the management of complex structures of objects.

### Client Code (`Main`)

The client code demonstrates how to use the Composite Pattern. It creates individual `Circle` objects and a `CompositeShape` that contains these circles. The client code shows how to interact with both individual shapes and the composite shape as a whole. By calling the `draw()` method on the `CompositeShape`, the client code can trigger the drawing of both individual shapes and all the shapes contained within the composite.

In this example, the `CompositeShape` class allows for adding and removing child components and retrieving a specific child component. The `draw()` method in the `CompositeShape` iterates over its children and calls their `draw()` methods, providing a way to handle both individual shapes and collections of shapes uniformly.
