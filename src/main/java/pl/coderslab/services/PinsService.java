package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dal.repositories.PinRepo;
import pl.coderslab.domain.devices.UsedPins;

import java.util.List;

@Component
public class PinsService {

    @Autowired
    PinRepo pinRepo;

    public List<UsedPins> createAvailablePins() {
        pinRepo.save(new UsedPins(1));
        pinRepo.save(new UsedPins(2));
        pinRepo.save(new UsedPins(3));
        pinRepo.save(new UsedPins(4));
        pinRepo.save(new UsedPins(5));

        return pinRepo.findAll();
    }

}
