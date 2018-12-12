package pl.coderslab.domain.devices;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "on_off_devices")
public class OnOffDevice extends DeviceDetails {

    //todo other init params

    private Integer pin;

    private boolean value;

    //CONCTRUCTOR, SETTERS AND GETTERS
    public OnOffDevice() {
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
