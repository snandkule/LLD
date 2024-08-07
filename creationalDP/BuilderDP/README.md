# Implementing the Builder Design Pattern

You are tasked with creating a system for constructing complex `Computer` objects. These objects will have various optional components such as CPU, GPU, RAM, storage, and an operating system. Implement the Builder design pattern to provide a flexible solution for creating different configurations of `Computer` objects.

## Requirements

### Computer Class

1. Create a `Computer` class with the following fields:
    - `String CPU`
    - `String GPU`
    - `int RAM`
    - `int storage`
    - `String operatingSystem`
2. Make all fields private and provide getter methods for each field.

### ComputerBuilder Class

1. Create a `ComputerBuilder` class that allows the construction of `Computer` objects.
2. Provide methods to set each field in the `Computer` class:
    - `ComputerBuilder setCPU(String cpu)`
    - `ComputerBuilder setGPU(String gpu)`
    - `ComputerBuilder setRAM(int ram)`
    - `ComputerBuilder setStorage(int storage)`
    - `ComputerBuilder setOperatingSystem(String os)`
3. Provide a `build()` method that returns a fully constructed `Computer` object.

### Testing

1. Create a test class `BuilderTest` that demonstrates the use of the `ComputerBuilder` to create different configurations of `Computer` objects.

## Example Usage

```java
public class main.java.com.example.library.Main {
    public static void main(String[] args) {
        Computer gamingPC = new ComputerBuilder()
            .setCPU("Intel Core i9")
            .setGPU("NVIDIA RTX 3080")
            .setRAM(32)
            .setStorage(2000)
            .setOperatingSystem("Windows 10")
            .build();

        Computer officePC = new ComputerBuilder()
            .setCPU("Intel Core i5")
            .setRAM(16)
            .setStorage(500)
            .setOperatingSystem("Windows 10")
            .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}
