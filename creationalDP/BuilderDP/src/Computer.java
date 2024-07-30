public class Computer {
    private String operatingSystem;
    private int ram;
    private String cpu;
    private String gpu;
    private int storage;

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }
    public int getRam() {
        return ram;
    }
    public String getCpu() {
        return cpu;
    }
    public String getGpu() {
        return gpu;
    }
    public int getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", GPU=" + gpu + ", RAM=" + ram + ", storage=" + storage
                + ", operatingSystem=" + operatingSystem + "]";
    }
}

