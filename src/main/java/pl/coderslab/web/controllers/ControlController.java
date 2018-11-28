package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.services.ControlService;
import pl.coderslab.web.dtos.DeviceStatusDto;

@Controller
@RequestMapping("/control")
public class ControlController {

    @Autowired
    ControlService controlService;

    @PostMapping("/onoff")
    @ResponseBody
    public boolean setOnOffStatus(@RequestBody DeviceStatusDto status) {
        controlService.onOffToggle();
        return true;
    }
}
