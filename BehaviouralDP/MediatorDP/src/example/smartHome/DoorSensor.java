package example.smartHome;

import example.smartHome.utils.EventEnum;

public class DoorSensor extends SmartDevice{

    public DoorSensor(SmartHomeMediator mediator) {
        super(mediator);
    }

    @Override
    public void onEvent(EventEnum event) {

        System.out.println("Received Event on Door: "+ event);
        smartHomeMediator.onEvent(this, event);

    }
}
