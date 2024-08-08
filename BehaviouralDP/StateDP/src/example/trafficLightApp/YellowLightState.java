package example.trafficLightApp;

import java.util.Timer;
import java.util.TimerTask;

public class YellowLightState implements TrafficLightState {
    private static final int YELLOW_LIGHT_DURATION = 2000; // Duration in milliseconds

    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Yellow Light - Prepare to stop.");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                trafficLight.setState(new RedLightState());
                trafficLight.changeLight();
            }
        }, YELLOW_LIGHT_DURATION);
    }

    @Override
    public void emergencyOverride(TrafficLight trafficLight) {
        System.out.println("Emergency Override - Immediate transition to Red Light.");
        trafficLight.setState(new RedLightState());
        trafficLight.changeLight();
    }
}
