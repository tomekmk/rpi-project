package pl.coderslab.domain.devices;

import javax.persistence.*;

@Entity
@Table(name = "on_off_devices")
public class OnOffDevice extends DeviceDetails implements DeviceInterface {

    //todo rpi + sending status
    //todo other init params

    private Integer pin;

    private boolean value;


    @Override
    public void switchOn() {
        this.value = true;
        System.out.println("włączono");
    }

    @Override
    public void switchOff() {
        this.value = false;
        System.out.println("wyłączono");
    }

    @Override
    public void toggle() {
        this.value = this.value ? false : true;
        System.out.println("przełączono");
    }

    //CONCTRUCTOR, SETTERS AND GETTERS
    public OnOffDevice() {
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean currentValue) {
        this.value = currentValue;
    }
}
