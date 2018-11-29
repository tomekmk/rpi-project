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
        boolean value = device.isValue();
        System.out.println("------------------------------------------------------------" + value);
        if (value) {
            device.setValue(false);
            device.setUpdated(LocalDateTime.now());
            onOffDeviceRepo.save(device);
            pinsService.setOnOffPinStatus(device.getPin(), false);
        } else {
            device.setValue(true);
            device.setUpdated(LocalDateTime.now());
            onOffDeviceRepo.save(device);
            pinsService.setOnOffPinStatus(device.getPin(), true);
        }

        return !value;
    }

    public boolean DimmingDeviceToggle(DeviceStatusDto status) {
        DimmingDevice device = dimmingDeviceRepo.findFirstById(status.getDeviceId());
        boolean value = device.isValue();
        if (value) {
            device.setValue(false);
            device.setDimmingValue(0);
            device.setUpdated(LocalDateTime.now());
            dimmingDeviceRepo.save(device);
        } else {
            device.setValue(true);
            device.setDimmingValue(100);
            device.setUpdated(LocalDateTime.now());
            dimmingDeviceRepo.save(device);
        }

        return !value;
    }

    public Integer DimmingDeviceValue(DeviceStatusDto status) {
        DimmingDevice device = dimmingDeviceRepo.findFirstById(status.getDeviceId());
        Integer dimmValue = status.getDimmValue();
        if (dimmValue == 0) {
            device.setValue(false);
            device.setDimmingValue(0);
            device.setUpdated(LocalDateTime.now());
            dimmingDeviceRepo.save(device);
        } else {
            device.setValue(true);
            device.setDimmingValue(dimmValue);
            device.setUpdated(LocalDateTime.now());
            dimmingDeviceRepo.save(device);
        }

        return dimmValue;
    }
}