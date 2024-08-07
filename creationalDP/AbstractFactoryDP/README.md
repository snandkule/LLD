# Implementing the Abstract Factory Design Pattern

You are tasked with creating a UI component library that supports different themes (e.g., Light Theme, Dark Theme). Each theme provides different implementations for UI components such as buttons and text fields. Implement the Abstract Factory design pattern to create instances of these UI components based on the selected theme.

## Requirements

### UIComponent Interface

1. Create a `Button` interface with a method `render()`.
2. Create a `TextField` interface with a method `render()`.

### Concrete UI Components

1. Implement at least two classes for each UI component type:
    - `LightButton` and `DarkButton` that implement the `Button` interface.
    - `LightTextField` and `DarkTextField` that implement the `TextField` interface.

### Abstract Factory Interface

1. Create a `UIFactory` interface with methods `createButton()` and `createTextField()`.

### Concrete Factories

1. Implement at least two factory classes that implement the `UIFactory` interface:
    - `LightThemeFactory` that creates `LightButton` and `LightTextField`.
    - `DarkThemeFactory` that creates `DarkButton` and `DarkTextField`.

### Client Code

1. Create a client class `ThemeApp` that uses the abstract factory to create and render UI components based on the selected theme.

## Example Usage

```java
public class main.java.com.example.library.java.com.example.editor.Main {
    public static void main(String[] args) {
        UIFactory factory = getThemeFactory("DARK");
        Button button = factory.createButton();
        TextField textField = factory.createTextField();

        button.render();
        textField.render();
    }

    private static UIFactory getThemeFactory(String theme) {
        switch (theme.toUpperCase()) {
            case "LIGHT":
                return new LightThemeFactory();
            case "DARK":
                return new DarkThemeFactory();
            default:
                throw new IllegalArgumentException("Unknown theme");
        }
    }
}
