package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.RaspberryPin;

import java.util.List;

@Component
public class PinsService {

    @Autowired
    PinRepo pinRepo;

    public List<RaspberryPin> createAvailablePins() {
        pinRepo.save(new RaspberryPin(1, true));
        pinRepo.save(new RaspberryPin(2, true));
        pinRepo.save(new RaspberryPin(3, true));
        pinRepo.save(new RaspberryPin(4, true));
        pinRepo.save(new RaspberryPin(5, true));

        return pinRepo.findAll();
    }

    public List<RaspberryPin> getAllPins() {
        return pinRepo.findAll();
    }

    public List<RaspberryPin> getAvailablePins() {
        return pinRepo.getAvailablePins();
    }

    public boolean isPinFree(Integer pinNumber) {
        return pinRepo.checkIsPinFree(pinNumber);
    }
}
