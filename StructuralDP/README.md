# Structural Design Patterns

Structural design patterns focus on how objects and classes are composed to form larger structures. They help simplify design by defining clear relationships between components, making systems easier to manage and maintain.

## Common Structural Design Patterns

### 1. Adapter (or Wrapper) Pattern
- **Purpose:** Allows objects with incompatible interfaces to work together by providing a compatible interface.
- **How It Works:** Creates a new class (the adapter) that wraps an existing class and provides an interface that clients expect.
- **Example:** Adapting a legacy code library's class to match the interface required by your application.

### 2. Bridge Pattern
- **Purpose:** Separates an abstraction from its implementation so that the two can vary independently.
- **How It Works:** Creates an abstraction layer (the bridge) that contains a reference to an implementation object, allowing both to evolve separately.
- **Example:** A graphic drawing application where the abstraction for drawing shapes is separated from the actual rendering logic.

### 3. Composite Pattern
- **Purpose:** Allows you to compose objects into tree structures to represent part-whole hierarchies, treating individual objects and compositions uniformly.
- **How It Works:** Creates a component interface and concrete classes for both individual objects and compositions.
- **Example:** A file system where files and directories are treated uniformly: directories contain files and other directories.

### 4. Decorator Pattern
- **Purpose:** Adds new functionality to an object dynamically without altering its structure.
- **How It Works:** Creates a set of decorator classes that wrap concrete components, adding functionality before or after delegating to the wrapped component.
- **Example:** A graphical user interface where basic windows can be dynamically decorated with features like scrollbars or borders.

### 5. Facade Pattern
- **Purpose:** Provides a simplified interface to a complex subsystem, making it easier to use.
- **How It Works:** Creates a facade class that wraps the complex subsystem and exposes a simpler interface to clients.
- **Example:** A home theater system with a facade that provides a simple interface for turning on the system, setting the input source, and adjusting the volume.

### 6. Flyweight Pattern
- **Purpose:** Reduces the cost of creating and managing a large number of similar objects by sharing as much data as possible.
- **How It Works:** Creates a flyweight factory that manages and reuses existing flyweight objects, representing the intrinsic state, while the extrinsic state is passed to the flyweights.
- **Example:** A text editor managing characters as flyweights where only the character data is shared, while each instance has its own position and formatting.

### 7. Proxy Pattern
- **Purpose:** Provides a surrogate or placeholder for another object to control access to it.
- **How It Works:** Creates a proxy class that acts as an intermediary to the real object, performing tasks like lazy initialization, access control, or logging.
- **Example:** A virtual proxy that loads a large image only when it’s actually needed, rather than loading it upfront.
