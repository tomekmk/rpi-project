package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.DimmingDeviceRepo;
import pl.coderslab.dal.repositories.OnOffDeviceRepo;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;
import pl.coderslab.web.dtos.DeviceStatusDto;

import java.time.LocalDateTime;

@Service
@Transactional
public class ControlService {

    @Autowired
    OnOffDeviceRepo onOffDeviceRepo;
    @Autowired
    DimmingDeviceRepo dimmingDeviceRepo;
    @Autowired
    PinsService pinsService;

    public boolean onOffDeviceToggle(DeviceStatusDto status) {
        OnOffDevice device = onOffDeviceRepo.findFirstById(status.getDeviceId());
        boolean state = device.isValue();

        device.setValue(!state);
        device.setUpdated(LocalDateTime.now());
        pinsService.setOnOffPinStatus(device.getPin(), !state);
        onOffDeviceRepo.save(device);

        return !state;
    }

    public boolean DimmingDeviceToggle(DeviceStatusDto status) {
        DimmingDevice device = dimmingDeviceRepo.findFirstById(status.getDeviceId());
        boolean state = device.isValue();
        return DimmingDeviceSetState(status, !state);
    }

    public boolean DimmingDeviceSetState(DeviceStatusDto status, boolean state) {
        DimmingDevice device = dimmingDeviceRepo.findFirstById(status.getDeviceId());
        int value = 0;
        if (state)
            value = 100;

        device.setValue(state);
        device.setDimmingValue(value);
        device.setUpdated(LocalDateTime.now());
        pinsService.setDimmingPinStatus(device.getPin(), value);
        dimmingDeviceRepo.save(device);

        return state;
    }

    public Integer DimmingDeviceValue(DeviceStatusDto status) {
        DimmingDevice device = dimmingDeviceRepo.findFirstById(status.getDeviceId());
        Integer dimmValue = status.getDimmValue();

        if (dimmValue == 0)
            DimmingDeviceSetState(status, false);
        else {
            device.setValue(true);
            device.setDimmingValue(dimmValue);
            device.setUpdated(LocalDateTime.now());
            pinsService.setDimmingPinStatus(device.getPin(), dimmValue);
            dimmingDeviceRepo.save(device);
        }

        return dimmValue;
    }
}