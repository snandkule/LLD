package example.trafficLightApp;

public class TrafficLight{
    TrafficLightState trafficLightState;

    public TrafficLight(){
        this.trafficLightState = new RedLightState();
    }
    public void setState(TrafficLightState trafficLightState) {
        this.trafficLightState = trafficLightState;
    }

    public void changeLight(){
        this.trafficLightState.handle(this);
    }

    public void emergencyOverride(){
        this.trafficLightState.emergencyOverride(this);
    }



}
