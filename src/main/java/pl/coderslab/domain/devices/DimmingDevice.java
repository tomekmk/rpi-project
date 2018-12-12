package pl.coderslab.domain.devices;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dimming_devices")
public class DimmingDevice extends DeviceDetails {

    private Integer pin;

    private boolean value;

    private Integer dimmingValue = 0;

    //CONCTRUCTOR, SETTERS AND GETTERS
    public DimmingDevice() {
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

    public Integer getDimmingValue() {
        return dimmingValue;
    }

    public void setDimmingValue(Integer dimmingValue) {
        this.dimmingValue = dimmingValue;
    }
}