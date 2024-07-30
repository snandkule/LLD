public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Computer gamingPC = new ComputerBuilder()
                .setCPU("Intel Core i9")
                .setGPU("NVIDIA RTX 3080")
                .setRam(32)
                .setStorage(2000)
                .setOperatingSystem("Windows 10")
                .build();

        Computer officePC = new ComputerBuilder()
                .setCPU("Intel Core i5")
                .setRam(16)
                .setStorage(500)
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}