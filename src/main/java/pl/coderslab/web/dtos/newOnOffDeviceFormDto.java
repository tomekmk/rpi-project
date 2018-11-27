package pl.coderslab.web.dtos;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.domain.location.Location;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class newOnOffDeviceFormDto {


    @NotNull @Size(min = 3)
    protected String name;

    protected String description;

    @NotNull
    protected Location location;

    protected Integer status;

    @NotNull @NotBlank
    protected Integer type;

    public newOnOffDeviceFormDto() {
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
}
