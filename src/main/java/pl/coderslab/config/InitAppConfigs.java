package pl.coderslab.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.services.PinsService;

import javax.annotation.PostConstruct;

@Component
public class InitAppConfigs {

    @Autowired
    PinsService pinsService;

    @PostConstruct
    private void initPins() {
        if (pinsService.getAllPins().size() == 0)
            pinsService.createAvailablePins();

        pinsService.initRaspberryPins();
    }

}
