package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.DeviceRepo;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;
import pl.coderslab.domain.devices.RaspberryPin;
import pl.coderslab.web.dtos.NewOnOffDeviceFormDto;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Service
@Transactional
public class SaveDeviceService {

    @Autowired
    DeviceRepo<OnOffDevice> onOffDeviceRepo;
    @Autowired
    DeviceRepo<DimmingDevice> dimmingDeviceRepo;
    @Autowired
    PinRepo pinRepo;
    @Autowired
    LocationService locationService;

    public void save(@Valid NewOnOffDeviceFormDto form) {
        OnOffDevice device = new OnOffDevice();
        device.setName(form.getName());
        device.setDescription(form.getDescription());
        device.setLocation(form.getLocation());
        device.setStatus(1);
        device.setType(1);
        device.setUpdated(LocalDateTime.now());
        device.setPin(form.getPin());
        device.setValue(true);
        onOffDeviceRepo.save(device);

        RaspberryPin devicePin = pinRepo.findFirstByPinNumber(device.getPin());
        devicePin.setAvailable(false);
        devicePin.setDeviceId(device.getId());
        pinRepo.save(devicePin);
    }

    public void save(DimmingDevice form) {
        DimmingDevice device = new DimmingDevice();
        device.setName(form.getName());
        device.setDescription(form.getDescription());
        device.setLocation(form.getLocation());
        device.setStatus(1);
        device.setType(form.getType());
        device.setUpdated(LocalDateTime.now());
        device.setPin(form.getPin());
        device.setValue(true);
        dimmingDeviceRepo.save(device);
    }
}
