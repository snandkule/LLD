import example.trafficLightApp.TrafficLight;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TrafficLight trafficLight = new TrafficLight();


        System.out.println("Traffic Light Simulation:");
        trafficLight.changeLight();

        try {
            Thread.sleep(2000); // Delay to show the effect before override
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficLight.emergencyOverride();
    }
}