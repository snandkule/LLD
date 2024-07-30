public class ComputerBuilder {
    private Computer computer;

    public ComputerBuilder(){
        computer = new Computer();
    }
    public ComputerBuilder setOperatingSystem(String operatingSystem){
        computer.setOperatingSystem(operatingSystem);
        return this;
    }
    public ComputerBuilder setRam(int ram){
        computer.setRam(ram);
        return this;
    }
    public ComputerBuilder setCPU(String cpu){
        computer.setCpu(cpu);
        return this;
    }
    public ComputerBuilder setGPU(String gpu){
        computer.setGpu(gpu);
        return this;
    }
    public ComputerBuilder setStorage(int storage){
        computer.setStorage(storage);
        return this;
    }
    public Computer build(){
        return this.computer;
    }

}
