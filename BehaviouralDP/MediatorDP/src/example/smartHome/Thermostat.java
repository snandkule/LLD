package example.smartHome;

import example.smartHome.utils.EventEnum;

public class Thermostat extends SmartDevice{

    boolean isOn;

    public Thermostat(SmartHomeMediator mediator) {
        super(mediator);
        this.isOn = false;
    }

    public void switchOnThermostat(){
        System.out.println("Turning on Thermostat");
        this.isOn = true;
    }

    public void switchOffThermostat(){
        System.out.println("Turning off Thermostat");
        this.isOn = false;
    }

    @Override
    public void onEvent(EventEnum event) {
        if(event.equals(EventEnum.DOOR_OPENED)){
            switchOnThermostat();
        } else if(event.equals(EventEnum.DOOR_CLOSED)){
            switchOffThermostat();
        }
    }
}

