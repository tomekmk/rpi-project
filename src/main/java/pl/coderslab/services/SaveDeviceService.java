package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.DeviceRepo;
import pl.coderslab.dal.repositories.DimmingDeviceRepo;
import pl.coderslab.dal.repositories.OnOffDeviceRepo;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;
import pl.coderslab.domain.devices.RaspberryPin;
import pl.coderslab.web.dtos.NewOnOffAndDimmingDeviceFormDto;

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
    PinsService pinsService;
    @Autowired
    OnOffDeviceRepo onOffDeviceRepoz;
    @Autowired
    DimmingDeviceRepo dimmingDeviceRepoz;

    private static Integer order = 1;

//    public void setMaxOrderId() {
//        Integer onOffMaxId = onOffDeviceRepoz.findMaxId();
//        Integer dimmingMaxId = dimmingDeviceRepoz.findMaxId();
//        if (onOffMaxId == null && dimmingMaxId == null)
//            return;
//        if (onOffMaxId == null)
//            order = dimmingMaxId + 1;
//        if (dimmingMaxId == null)
//            order = onOffMaxId + 1;
//
//
//        if (onOffMaxId > dimmingMaxId)
//            order = onOffMaxId + 1;
//        else
//            order = dimmingMaxId + 1;
//    }

    public void saveOnOffDevice(@Valid NewOnOffAndDimmingDeviceFormDto form) {
        OnOffDevice device = new OnOffDevice();
        device.setName(form.getName());
        device.setDescription(form.getDescription());
        device.setOrderId(order++);
        device.setLocation(form.getLocation());
        device.setStatus(1);
        device.setType(1);
        device.setUpdated(LocalDateTime.now());
        device.setPin(form.getPin());
        device.setValue(false);
        onOffDeviceRepo.save(device);
        setRaspberryOnePin(device.getPin(), device.getId());
        pinsService.initNewOnOffPin(device.getPin());
    }

    public void saveDimmingDevice(@Valid NewOnOffAndDimmingDeviceFormDto form) {
        DimmingDevice device = new DimmingDevice();
        device.setName(form.getName());
        device.setDescription(form.getDescription());
        device.setOrderId(order++);
        device.setLocation(form.getLocation());
        device.setStatus(1);
        device.setType(2);
        device.setUpdated(LocalDateTime.now());
        device.setPin(form.getPin());
        device.setValue(false);
        device.setDimmingValue(0);
        dimmingDeviceRepo.save(device);
        setRaspberryOnePin(device.getPin(), device.getId());
        pinsService.initNewDimmingPin(device.getPin());
    }

    private void setRaspberryOnePin(Integer pin, Long deviceId) {
        RaspberryPin devicePin = pinRepo.findFirstByPinNumber(pin);
        devicePin.setAvailable(false);
        devicePin.setDeviceId(deviceId);
        pinRepo.save(devicePin);
    }
}
