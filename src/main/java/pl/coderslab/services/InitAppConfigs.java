package pl.coderslab.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitAppConfigs {

    @Autowired
    PinsService pinsService;

    @PostConstruct
    private void initPins(){
        pinsService.createAvailablePins();

    }

}
