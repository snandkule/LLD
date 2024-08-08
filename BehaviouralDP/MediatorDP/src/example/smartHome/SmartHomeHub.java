package example.smartHome;

import example.smartHome.utils.EventEnum;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub implements SmartHomeMediator{

    List<SmartDevice> devices;

    public SmartHomeHub(){
        devices = new ArrayList<>();
    }
    @Override
    public void registerDevice(String name, SmartDevice device) {
        this.devices.add(device);
    }

    @Override
    public void onEvent(SmartDevice device, EventEnum event) {
        for(SmartDevice localDevice: devices){
            if(localDevice != device){
                localDevice.onEvent(event);
            }
        }
    }
}
