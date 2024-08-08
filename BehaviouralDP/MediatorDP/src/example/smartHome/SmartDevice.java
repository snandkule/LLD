package example.smartHome;

import example.smartHome.utils.EventEnum;

public abstract class SmartDevice {
    SmartHomeMediator smartHomeMediator;

    public SmartDevice(SmartHomeMediator mediator){
        this.smartHomeMediator = mediator;
    }

    public abstract void onEvent(EventEnum event);
}
