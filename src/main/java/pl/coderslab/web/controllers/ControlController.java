package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.domain.devices.DeviceDetails;
import pl.coderslab.services.ControlService;
import pl.coderslab.services.ViewService;
import pl.coderslab.web.dtos.DeviceStatusDto;

import java.util.List;

@Controller
@RequestMapping("/control")
public class ControlController {

    @Autowired
    ControlService controlService;
    @Autowired
    ViewService viewService;

    @PostMapping("/toggle")
    @ResponseBody
    public boolean setOnOffDeviceToggleStatus(@RequestBody DeviceStatusDto status) {
        return controlService.onOffDeviceToggle(status);
    }

    @PostMapping("/dimming/toggle")
    @ResponseBody
    public boolean setDimmingDeviceToggleStatus(@RequestBody DeviceStatusDto status) {
        return controlService.DimmingDeviceToggle(status);
    }

    @PostMapping("/dimming/value")
    @ResponseBody
    public Integer setDimmingDeviceValueStatus(@RequestBody DeviceStatusDto status) {
        return controlService.DimmingDeviceValue(status);
    }

    @PostMapping("/getall")
    @ResponseBody
    public List<DeviceDetails> getAllDevices() {
        return viewService.getAllDevicesOrdered();
    }
}
