import example.smartHome.*;

import static example.smartHome.utils.EventEnum.DOOR_CLOSED;
import static example.smartHome.utils.EventEnum.DOOR_OPENED;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create the mediator (SmartHomeHub)
        SmartHomeHub hub = new SmartHomeHub();

        // Create devices
        Light livingRoomLight = new Light(hub);
        Thermostat thermostat = new Thermostat(hub);
        SecurityCamera camera = new SecurityCamera(hub);
        DoorSensor doorSensor = new DoorSensor(hub);

        // Register devices with the smart home hub
        hub.registerDevice("LivingRoomLight", livingRoomLight);
        hub.registerDevice("Thermostat", thermostat);
        hub.registerDevice("SecurityCamera", camera);
        hub.registerDevice("DoorSensor", doorSensor);

        // Simulate door opening
        doorSensor.onEvent(DOOR_OPENED);

        // Simulate door closing
        doorSensor.onEvent(DOOR_CLOSED);
    }
}