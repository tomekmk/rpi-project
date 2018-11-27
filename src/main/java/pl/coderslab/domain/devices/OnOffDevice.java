package pl.coderslab.domain.devices;

import javax.persistence.*;

@Entity
@Table(name = "on_off_devices")
public class OnOffDevice extends DeviceDetails implements DeviceInterface {
    //todo rpi + sending status
    //todo other init params
    private Integer pin_number;

    //todo move value to DTO
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
        if (this.value)
            this.value = false;
        else
            this.value = true;
        System.out.println("przełączono");
    }

    //CONCTRUCTOR, SETTERS AND GETTERS
    public OnOffDevice() {
    }

    public Integer getPin_number() {
        return pin_number;
    }

    public void setPin_number(Integer pin_number) {
        this.pin_number = pin_number;
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
