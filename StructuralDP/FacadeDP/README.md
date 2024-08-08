# Facade Pattern

## Overview

The **Facade Pattern** is a structural design pattern that provides a simplified interface to a complex subsystem. It is used when you want to hide the complexities of a subsystem and provide a more straightforward, unified interface for clients to interact with.

### Key Concepts

- **Subsystem:** A collection of classes and components that work together to perform a set of related tasks. The subsystem can be complex, with many interdependent parts.
- **Facade:** A single class that provides a simple interface to the complex subsystem. The facade shields clients from the details of the subsystem, allowing them to interact with it through a clean and easy-to-use interface.

### Intent

The main intent of the Facade Pattern is to provide a high-level interface that makes the subsystem easier to use without exposing the underlying complexity. This is particularly useful when you have a complex system with many interdependent classes and you want to provide a simpler way for clients to interact with it.

## UML Diagram (Textual Representation)

Here's a simplified UML representation of the Facade Pattern using text:

```plaintext
+-----------------+
|    Facade       |
+-----------------+
| + operationA()  |
| + operationB()  |
+-----------------+
       |
       | calls
       |
+------------------+     +-------------------+
| SubsystemClassA  |     | SubsystemClassB    |
+------------------+     +-------------------+
| + methodA1()     |     | + methodB1()       |
| + methodA2()     |     | + methodB2()       |
+------------------+     +-------------------+
```


### Components

- **Facade:**
    - The class that clients interact with. It provides a simplified interface by internally managing the complexity of the subsystem.
    - `operationA()` and `operationB()` are example methods that the facade offers to the client.

- **SubsystemClassA and SubsystemClassB:**
    - These are parts of the subsystem that perform various tasks. The facade calls methods on these classes internally to fulfill client requests.

## Example: Home Theater System

Let's use a home theater system as an example to illustrate the Facade Pattern.

### Scenario

Imagine you have a home theater system with the following components:

- **Amplifier**
- **DVD Player**
- **Projector**
- **Lights**
- **Screen**

To watch a movie, you need to:

1. Turn on the amplifier and set the input.
2. Turn on the DVD player and insert a disc.
3. Lower the screen.
4. Dim the lights.
5. Turn on the projector and start it.

The process is quite complex for someone who just wants to watch a movie. This is where the Facade Pattern comes in handy.

### Implementation in Java

**Subsystem Classes:**

```java
class Amplifier {
    public void on() {
        System.out.println("Amplifier is on.");
    }

    public void setDvd(String dvd) {
        System.out.println("Amplifier setting DVD player to " + dvd + ".");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level + ".");
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie + ".");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void wideScreenMode() {
        System.out.println("Projector set to wide screen mode.");
    }
}

class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater lights dimmed to " + level + ".");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is down.");
    }
}
```

**Facade Class:**
```java
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, TheaterLights lights, Screen screen) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd("DVD Player");
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        lights.dim(100);
        screen.down();
        projector.on();
        dvd.play("");
    }
}
```
**Client Code:**
```java
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights, screen);

        homeTheater.watchMovie("Inception");
    }
}
```

## How It Works

- **Client:** The client (user) interacts only with the `HomeTheaterFacade` class.
- **Facade:** The `HomeTheaterFacade` class provides a simplified interface to control the entire home theater system. The user simply calls `watchMovie("Inception")` to start the movie.
- **Subsystem:** The facade internally manages the complex interactions between the subsystem components (`Amplifier`, `DVDPlayer`, `Projector`, etc.).

## Benefits of the Facade Pattern

- **Simplification:** Clients get a simplified interface, making the system easier to use.
- **Decoupling:** The facade decouples the client from the subsystem, allowing the subsystem to evolve independently without affecting the client.
- **Centralized Control:** The facade centralizes control over the subsystem, which can improve maintainability and reduce the chance of misuse.

## Conclusion

The Facade Pattern is an excellent way to simplify interactions with complex systems, making them easier to use and more maintainable. It's particularly useful when you have a complex subsystem with many interdependent parts, and you want to provide a simpler way for clients to interact with it.
