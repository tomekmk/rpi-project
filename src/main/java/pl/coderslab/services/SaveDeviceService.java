package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dal.repositories.DeviceRepo;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;
import pl.coderslab.domain.devices.UsedPins;

@Service
@Transactional
public class SaveDeviceService {

    @Autowired
    DeviceRepo<OnOffDevice> onOffDeviceRepo;
    @Autowired
    DeviceRepo<DimmingDevice> dimmingDeviceRepo;
    @Autowired
    PinRepo pinRepo;

    public void save(OnOffDevice device) {
//        UsedPins pin = pinRepo.findFirstByPinNumber()
        onOffDeviceRepo.save(device);
    }

    public void save(DimmingDevice device) {
        dimmingDeviceRepo.save(device);
    }

    public boolean isPinFree(Integer pin) {
        return pinRepo.findFirstByPinNumber(pin) == null;
    }
}
