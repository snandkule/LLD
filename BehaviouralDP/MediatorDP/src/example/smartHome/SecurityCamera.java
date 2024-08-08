package example.smartHome;

import example.smartHome.utils.EventEnum;

public class SecurityCamera extends SmartDevice{

    boolean isOn;

    public SecurityCamera(SmartHomeMediator mediator) {
        super(mediator);
        this.isOn = false;
    }

    public void switchOnSecurityCamera(){
        System.out.println("Turning on SecurityCamera");
        this.isOn = true;
    }

    public void switchOffSecurityCamera(){
        System.out.println("Turning off SecurityCamera");
        this.isOn = false;
    }

    @Override
    public void onEvent(EventEnum event) {
        if(event.equals(EventEnum.DOOR_OPENED)){
            switchOffSecurityCamera();
        } else if(event.equals(EventEnum.DOOR_CLOSED)){
            switchOnSecurityCamera();
        }
    }
}


