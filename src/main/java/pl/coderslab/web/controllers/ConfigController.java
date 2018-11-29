package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.devices.DeviceType;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.RaspberryPin;
import pl.coderslab.domain.location.Location;
import pl.coderslab.services.LocationService;
import pl.coderslab.services.PinsService;
import pl.coderslab.services.SaveDeviceService;
import pl.coderslab.web.dtos.NewOnOffAndDimmingDeviceFormDto;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    SaveDeviceService saveDeviceService;

    @Autowired
    PinsService pinsService;

    @Autowired
    LocationService locationService;

    private List<DeviceType> types;

    @PostConstruct
    private void init() {
        this.types = Arrays.asList(
                new DeviceType("onoff", "Urządzenie on/off"),
                new DeviceType("dimming", "Lampa ściemnialna"),
                new DeviceType("ledrgb", "Led RGB"));
    }

    @GetMapping
    public String selectTypeDevice(Model model) {
        model.addAttribute("types", this.types);
        return "config/select-new-type-device";
    }

    @PostMapping
    public String addNewDeviceForm(@RequestParam String type, Model model) {
        List<RaspberryPin> availablePins = pinsService.getAvailablePins();
        model.addAttribute("pinsList", availablePins);

        if (type.equals("onoff")) {
            model.addAttribute("newDevice", new NewOnOffAndDimmingDeviceFormDto());
            return "/config/new-onoff-device";
        }

        if (type.equals("dimming")) {
            model.addAttribute("newDevice", new NewOnOffAndDimmingDeviceFormDto());
            return "/config/new-dimming-device";
        }

        return "redirect:/";
    }

    @PostMapping("/addnew/1")
    public String addNewOnOffDevice(@ModelAttribute("newDevice") @Valid NewOnOffAndDimmingDeviceFormDto device,
                                    BindingResult bindingResult,
                                    Model model) {

        if (!bindingResult.hasErrors() && !pinsService.isPinFree(device.getPin()))
            bindingResult.rejectValue("pin","","Ten pin jest już zajęty, ktoś Cię wyprzedził :)");

        if (bindingResult.hasErrors()) {
            List<RaspberryPin> availablePins = pinsService.getAvailablePins();
            model.addAttribute("pinsList", availablePins);
            return "/config/new-onoff-device";
        }

        saveDeviceService.saveOnOffDevice(device);
        return "redirect:/";
    }

    @PostMapping("/addnew/2")
    public String addNewDimmingDevice(@ModelAttribute("newDevice") @Valid NewOnOffAndDimmingDeviceFormDto device,
                                      BindingResult bindingResult,
                                      Model model) {

        if (!bindingResult.hasErrors() && !pinsService.isPinFree(device.getPin()))
            bindingResult.rejectValue("pin","","Ten pin jest już zajęty, ktoś Cię wyprzedził :)");

        if (bindingResult.hasErrors()) {
            List<RaspberryPin> availablePins = pinsService.getAvailablePins();
            model.addAttribute("pinsList", availablePins);
            return "/config/new-dimming-device";
        }

        saveDeviceService.saveDimmingDevice(device);
        return "redirect:/";
    }




    // --------------------- MODEL ATTRIBUTES -----------------------
    @ModelAttribute("locations")
    public List<Location> locations() {
        return locationService.getAllLocations();
    }

    @ModelAttribute("menu")
    public Integer menuActive() {
        return 3;
    }
}


