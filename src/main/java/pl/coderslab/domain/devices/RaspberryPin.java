package pl.coderslab.domain.devices;

import javax.persistence.*;

@Entity
@Table(name = "raspberry_pins")
public class RaspberryPin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pinNumber;

    private Long deviceId;

    private Boolean available;

    public RaspberryPin() {
    }

    public RaspberryPin(Integer pinNumber, Boolean available) {
        this.pinNumber = pinNumber;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(Integer pinNumber) {
        this.pinNumber = pinNumber;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return pinNumber.toString();
    }
}
