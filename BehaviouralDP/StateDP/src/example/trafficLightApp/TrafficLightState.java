package example.trafficLightApp;

public interface TrafficLightState {
    public void handle(TrafficLight trafficLight);

    public void emergencyOverride(TrafficLight trafficLight);
}
