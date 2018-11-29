package pl.coderslab.web.dtos;

import pl.coderslab.domain.location.Location;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewOnOffAndDimmingDeviceFormDto {


    @NotNull(message = "Nazwa nie może być pusta.")
    @Size(min = 3, message = "Nazwa musi zawierać conajmniej 3 znaki.")
    protected String name;

    protected String description;

    @NotNull(message = "Musisz wybrać lokalizację urządzenia. Jeżeli niema żadnej, najpierw ją utwórz.")
    protected Location location;

//    @NotNull  //todo typy urządzeń
//    @NotBlank
    protected Integer type;

    @NotNull(message = "Musisz wybrać pin raspberry. Jeżeli niema dostępnych, usuń jakieś urządzenie.")
    protected Integer pin;

    public NewOnOffAndDimmingDeviceFormDto() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
