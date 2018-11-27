package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.devices.DeviceType;
import pl.coderslab.domain.devices.DimmingDevice;
import pl.coderslab.domain.devices.OnOffDevice;
import pl.coderslab.domain.devices.UsedPins;
import pl.coderslab.services.PinsService;
import pl.coderslab.services.SaveDeviceService;

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

    List<DeviceType> types;
    List<UsedPins> availablePins;

    @PostConstruct
    private void init() {
        System.out.println("executed");
        System.out.println("======");
        this.types = Arrays.asList(
                new DeviceType("onoff", "Urządzenie on/off"),
                new DeviceType("dimming", "Lampa ściemnialna"),
                new DeviceType("ledrgb", "Led RGB"));

//        availablePins = pinsService.createAvailablePins();
    }

    @GetMapping
    public String selectTypeDevice(Model model) {
        model.addAttribute("types", this.types);     //todo: return correct object after choose device type
        return "config/select-new-type-device";
    }

    @PostMapping
    public String addNewDeviceForm(@RequestParam String type, Model model) {
        if (type.equals("onoff")) {
            model.addAttribute("newDevice", new OnOffDevice());
            model.addAttribute("typeNumber", 1);
            model.addAttribute("pinsList", availablePins);
            return "/config/new-onoff-device";
        }
        return "/config/new-onoff-device";
    }

    @PostMapping("/addnew/1")
    public String addNewOnOffDevice(@ModelAttribute("newDevice") @Valid OnOffDevice device,
                                    BindingResult bindingResult) {

//        if (!saveDeviceService.isPinFree(device.getPin().getPinNumber())) {
//            bindingResult.addError(new ObjectError("pin", "Ten pin jest już zajęty"));
//        }
//
//        if (bindingResult.hasErrors())
//            return "/config/new-onoff-device";

        saveDeviceService.save(device);
        return "redirect:/";
    }

    @PostMapping("/addnew/2")
    public String addNewDimmingDevice(@ModelAttribute("newDevice") DimmingDevice device) {
        saveDeviceService.save(device);
        return "redirect:/";
    }

//    @PostMapping("/addnew/3")
//    public String addNewLedRgbDevice(@ModelAttribute("newDevice") DimmingDevice device) {
//        saveDeviceService.save(device);
//        return "redirect:/";
//    }
}


