package example.smartHome;

import example.smartHome.utils.EventEnum;

public interface SmartHomeMediator {

    public void registerDevice(String name, SmartDevice device);

    public void onEvent(SmartDevice device, EventEnum event );
}
