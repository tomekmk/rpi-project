package pl.coderslab.domain.devices;

import pl.coderslab.domain.location.Location;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class DeviceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @Column(columnDefinition = "TEXT", length = 100)
    protected String description;

    @ManyToOne
    protected Location location;

    protected Integer status;

    protected Integer type;

    protected Integer orderId;

    protected LocalDateTime updated;


    //CONCTRUCTOR, SETTERS AND GETTERS
    public DeviceDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
