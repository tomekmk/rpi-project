package pl.coderslab.web.dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class LocationFormDTO {

    @NotNull(message = "Nazwa pomieszczenia nie może być pusta")
    @NotBlank(message = "Nazwa pomieszczenia nie może być pusta")
    private String name;

    private String type;

    private Integer floor;

    public LocationFormDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
