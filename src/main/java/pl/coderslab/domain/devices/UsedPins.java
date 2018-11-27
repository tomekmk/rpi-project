package pl.coderslab.domain.devices;

import javax.persistence.*;

@Entity
@Table(name = "used_pins")
public class UsedPins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pinNumber;

    private Integer deviceId;

    private Boolean available;

    public UsedPins() {
    }

    public UsedPins(Integer pinNumber) {
        this.pinNumber = pinNumber;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
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

    @Override
    public String toString() {
        return pinNumber.toString();
    }
}
