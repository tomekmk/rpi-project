package pl.coderslab.domain.devices;

import javax.persistence.*;

@Entity
@Table(name = "dimming_devices")
public class DimmingDevice extends DeviceDetails implements DeviceInterface {
    //todo rpi + sending status

    private Integer pin_number;
    private boolean value = false;
    private Integer dimmingValue = 0;


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
    public DimmingDevice() {
    }

    public Integer getPin_number() {
        return pin_number;
    }

    public void setPin_number(Integer pin_number) {
        this.pin_number = pin_number;
    }

    public Integer getDimmingValue() {
        return dimmingValue;
    }

    public void setDimmingValue(Integer dimmingValue) {
        this.dimmingValue = dimmingValue;
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