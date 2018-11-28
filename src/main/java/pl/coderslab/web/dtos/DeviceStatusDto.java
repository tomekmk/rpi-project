package pl.coderslab.web.dtos;

public class DeviceStatusDto {

    private Long type;
    private Long deviceId;
    private boolean value;

    public DeviceStatusDto() {
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
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
}