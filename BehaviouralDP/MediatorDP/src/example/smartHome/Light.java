package example.smartHome;

import example.smartHome.utils.EventEnum;

public class Light extends SmartDevice{

    boolean isOn;

    public Light(SmartHomeMediator mediator) {
        super(mediator);
        this.isOn = false;
    }

    public void switchOnLight(){
        System.out.println("Turning on Light");
        this.isOn = true;
    }

    public void switchOffLight(){
        System.out.println("Turning off Light");
        this.isOn = false;
    }

    @Override
    public void onEvent(EventEnum event) {
        if(event.equals(EventEnum.DOOR_OPENED)){
            switchOnLight();
        } else if(event.equals(EventEnum.DOOR_CLOSED)){
            switchOffLight();
        }
    }
}
