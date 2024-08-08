package example.trafficLightApp;

import java.util.Timer;
import java.util.TimerTask;

public class RedLightState implements TrafficLightState{
    private static final int RED_LIGHT_DURATION = 5000;
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Red Light - Vehicles must stop.");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                trafficLight.setState(new GreenLightState());
                trafficLight.changeLight();
            }
        }, RED_LIGHT_DURATION);

    }

    @Override
    public void emergencyOverride(TrafficLight trafficLight) {
        System.out.println("Emergency Override - Immediate transition to Red Light.");
        trafficLight.setState(this);

    }
}
