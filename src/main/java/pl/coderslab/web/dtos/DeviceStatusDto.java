package pl.coderslab.web.dtos;

public class DeviceStatusDto {

    private Integer type;
    private Long deviceId;
    private boolean value;
    private Integer dimmValue;
    private Integer hue;
    private Integer saturation;

    public DeviceStatusDto() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Integer getDimmValue() {
        return dimmValue;
    }

    public void setDimmValue(Integer dimmValue) {
        this.dimmValue = dimmValue;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }
}