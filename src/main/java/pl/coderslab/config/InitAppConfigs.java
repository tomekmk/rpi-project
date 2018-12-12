package pl.coderslab.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.services.PinsService;
import pl.coderslab.services.SaveDeviceService;

import javax.annotation.PostConstruct;

@Component
public class InitAppConfigs {

    @Autowired
    PinsService pinsService;
    @Autowired
    SaveDeviceService saveDeviceService;

    @PostConstruct
    private void initPins() {
        if (pinsService.getAllPins().size() == 0)
            pinsService.createAvailablePins();

        pinsService.initRaspberryPins();
    }

}
