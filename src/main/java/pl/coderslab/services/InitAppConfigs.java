package pl.coderslab.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.domain.devices.RaspberryPin;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitAppConfigs {

    @Autowired
    PinsService pinsService;

    @PostConstruct
    private void initPins() {
        if (pinsService.getAllPins().size() == 0)
            pinsService.createAvailablePins();
    }
}
