# Flyweight Pattern in Java

## Detailed Explanation

The **Flyweight Pattern** is designed to minimize memory usage by sharing as much data as possible between similar objects. It works by separating the object’s state into two parts:

1. **Intrinsic State**: This is the state that is shared among multiple objects. It is independent of the object's context and can be reused.
2. **Extrinsic State**: This is the state that is unique to each object. It is context-dependent and cannot be shared.

### Participants in the Flyweight Pattern

- **Flyweight Interface (`CharacterFlyweight`)**: Declares an interface through which flyweights can receive and act on extrinsic state.
- **ConcreteFlyweight (`ConcreteCharacter`)**: Implements the Flyweight interface and stores intrinsic state that can be shared.
- **FlyweightFactory (`CharacterFactory`)**: Creates and manages flyweight objects, ensuring that they are shared rather than duplicated.
- **Client (`DocumentEditor`)**: Maintains references to flyweights and computes or stores extrinsic state.

### Textual UML Diagram

Here's how the Flyweight Pattern can be represented in a textual UML diagram:

```plaintext
+--------------------+
| CharacterFlyweight  |<-------------------------+
|--------------------|                          |
| + render(x, y)      |                          |
+--------------------+                          |
       /\                                       |
       ||                                       |
       ||                                       |
+--------------------+          +----------------------------+
|ConcreteCharacter   |          | CharacterFactory            |
|--------------------|          |----------------------------|
| - character        |          | - characters: HashMap<Key,  |
| - font             |          |   CharacterFlyweight>       |
| - size             |          |----------------------------|
| + render(x, y)     |          | + getCharacter(char, font,  |
+--------------------+          |   size): CharacterFlyweight |
                                 +----------------------------+

                            +-----------------+
                            | DocumentEditor  |
                            |-----------------|
                            | - characters:   |
                            |   List<CharacterFlyweight>|
                            | - positions:    |
                            |   List<Point>   |
                            +-----------------+
```
## Example: Text Editor Rendering Characters

In this example, we simulate a text editor that renders characters on the screen. Instead of creating a new object for every character, we use the Flyweight Pattern to share character objects where possible.

### 1. Flyweight Interface (`CharacterFlyweight`)

```java
// Flyweight interface
interface CharacterFlyweight {
    void render(int x, int y);
}
```
This interface defines the render method, which takes the extrinsic state (position) as input.

### 2. ConcreteFlyweight Class (`ConcreteCharacter`)
```java
// ConcreteFlyweight class
class ConcreteCharacter implements CharacterFlyweight {
    private final char character; // Intrinsic state
    private final String font;
    private final int size;

    public ConcreteCharacter(char character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering character '" + character + "' at (" + x + ", " + y +
                ") with font " + font + ", size " + size);
    }
}
```
This class implements the `CharacterFlyweight` interface and stores the intrinsic state (character, font, and size).

### 3. Flyweight Factory Class (`CharacterFactory`)
```java
import java.util.HashMap;
import java.util.Map;

// FlyweightFactory class
class CharacterFactory {
    private final Map<String, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char character, String font, int size) {
        String key = character + "_" + font + "_" + size;
        if (!characters.containsKey(key)) {
            characters.put(key, new ConcreteCharacter(character, font, size));
        }
        return characters.get(key);
    }
}
```
The `CharacterFactory` manages the creation and sharing of `ConcreteCharacter` objects. If a character with the same intrinsic state already exists, it returns the existing instance; otherwise, it creates a new one.

### 4. Client Class (`DocumentEditor`)
```java
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

// Client class
class DocumentEditor {
    private final List<CharacterFlyweight> characters = new ArrayList<>();
    private final List<Point> positions = new ArrayList<>();

    public void addCharacter(char character, String font, int size, int x, int y) {
        CharacterFlyweight flyweight = CharacterFactory.getInstance().getCharacter(character, font, size);
        characters.add(flyweight);
        positions.add(new Point(x, y));
    }

    public void renderDocument() {
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).render(positions.get(i).x, positions.get(i).y);
        }
    }
}
```
The `DocumentEditor` class uses the `CharacterFactory` to get `CharacterFlyweight` instances and stores them along with their positions. When rendering the document, it uses the flyweight objects to render characters at their respective positions.

### 5. Singleton Pattern for CharacterFactory
For efficient use, we'll make the `CharacterFactory` a singleton, ensuring only one instance manages the characters:
```java
// Singleton pattern for CharacterFactory
class CharacterFactory {
    private static final CharacterFactory instance = new CharacterFactory();
    private final Map<String, CharacterFlyweight> characters = new HashMap<>();

    private CharacterFactory() {}

    public static CharacterFactory getInstance() {
        return instance;
    }

    public CharacterFlyweight getCharacter(char character, String font, int size) {
        String key = character + "_" + font + "_" + size;
        if (!characters.containsKey(key)) {
            characters.put(key, new ConcreteCharacter(character, font, size));
        }
        return characters.get(key);
    }
}
```
### Usage Example
Here’s how you can use these classes to render a document:
```java
public class FlyweightExample {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();

        // Adding characters to the document
        editor.addCharacter('H', "Arial", 12, 0, 0);
        editor.addCharacter('e', "Arial", 12, 10, 0);
        editor.addCharacter('l', "Arial", 12, 20, 0);
        editor.addCharacter('l', "Arial", 12, 30, 0);
        editor.addCharacter('o', "Arial", 12, 40, 0);

        editor.addCharacter('H', "Arial", 12, 50, 0); // Reuse 'H'
        editor.addCharacter('e', "Arial", 12, 60, 0); // Reuse 'e'

        // Render the document
        editor.renderDocument();
    }
}
```
### Output
When you run the `FlyweightExample` class, you might see something like this:
```plaintext
Rendering character 'H' at (0, 0) with font Arial, size 12
Rendering character 'e' at (10, 0) with font Arial, size 12
Rendering character 'l' at (20, 0) with font Arial, size 12
Rendering character 'l' at (30, 0) with font Arial, size 12
Rendering character 'o' at (40, 0) with font Arial, size 12
Rendering character 'H' at (50, 0) with font Arial, size 12
Rendering character 'e' at (60, 0) with font Arial, size 12
```

## Explanation of the Code

- **Intrinsic State (Shared):** The characters, fonts, and sizes are shared by the flyweight objects (`ConcreteCharacter`).
- **Extrinsic State (Unique):** The positions (`x`, `y`) where the characters are rendered are passed as arguments and are unique to each character rendering.

## Benefits of Using the Flyweight Pattern

- **Memory Efficiency:** By sharing common data (intrinsic state), the memory consumption is reduced.
- **Performance Improvement:** Reducing the number of objects created can improve the performance of the system.

## When to Use the Flyweight Pattern

- **When you have a large number of similar objects.**
- **When memory usage is a concern, and there is potential to share data between objects.**
- **When the intrinsic state can be shared among objects and extrinsic state can be passed as needed.**

The Flyweight Pattern is particularly useful in scenarios like rendering text, managing large datasets, or simulating large environments with many similar objects.
