package example.trafficLightApp;

import java.util.Timer;
import java.util.TimerTask;

public class GreenLightState implements TrafficLightState {

    private static final int GREEN_LIGHT_DURATION = 5000; // Duration in milliseconds


    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Green Light - Vehicles can go.");
        // Transition to Yellow Light after duration
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                trafficLight.setState(new YellowLightState());
                trafficLight.changeLight();
            }
        }, GREEN_LIGHT_DURATION);
    }

    @Override
    public void emergencyOverride(TrafficLight trafficLight) {
        System.out.println("Emergency Override - Immediate transition to Red Light.");
        trafficLight.setState(new RedLightState());
        trafficLight.changeLight();
    }
}
