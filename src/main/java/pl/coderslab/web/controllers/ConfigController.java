package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dal.repositories.DimmingDeviceRepo;
import pl.coderslab.dal.repositories.OnOffDeviceRepo;
import pl.coderslab.domain.devices.*;
import pl.coderslab.domain.location.Location;
import pl.coderslab.services.LocationService;
import pl.coderslab.services.PinsService;
import pl.coderslab.services.SaveDeviceService;
import pl.coderslab.services.ViewService;
import pl.coderslab.web.dtos.NewOnOffAndDimmingDeviceFormDto;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
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
    @Autowired
    ViewService viewService;
    @Autowired
    OnOffDeviceRepo onOffDeviceRepo;
    @Autowired
    DimmingDeviceRepo dimmingDeviceRepo;

    private List<DeviceType> types;

    @PostConstruct
    private void init() {
        this.types = Arrays.asList(
                new DeviceType("onoff", "Urządzenie on/off"),
                new DeviceType("dimming", "Lampa ściemnialna"),
                new DeviceType("ledrgb", "Led RGB"),
                new DeviceType("tempsensor", "Czujnik temperatury"),
                new DeviceType("motionsensor", "Czujnik ruchu"));
    }

    @GetMapping
    public String selectTypeDevice(Model model) {
        model.addAttribute("types", this.types);
        List<DeviceDetails> devices = viewService.getAllDevicesOrdered();
        if (devices.size() != 0) {
            model.addAttribute("isAnyDevice", true);
            model.addAttribute("devices", viewService.getAllDevicesOrdered());
        }
        return "config/select-new-type-device";
    }

    @GetMapping("/delete/1/{id}")
    String deleteOnOffDevice(@PathVariable Long id) {
        saveDeviceService.deleteOnOffDevice(id);
        return "redirect:/config";
    }

    @GetMapping("/delete/2/{id}")
    String deleteDimmingDevice(@PathVariable Long id) {
        saveDeviceService.deleteDimmingDevice(id);
        return "redirect:/config";
    }

    @GetMapping("/edit/1/{id}")
    String editOnOffDevice(@PathVariable Long id,
                           Model model) {
        OnOffDevice device = onOffDeviceRepo.findFirstById(id);
        RaspberryPin pin = pinsService.getOnePin(device.getPin());

        List<RaspberryPin> availablePins = new ArrayList<>();
        availablePins.add(pin);
        availablePins.addAll(pinsService.getAvailablePins());

        model.addAttribute("editingDevice", device);
        model.addAttribute("pinsList", availablePins);

        return "/config/edit-onoff-device";
    }

    @PostMapping("/edit/1/{id}")
    public String editOnOffDevice(@ModelAttribute("editingDevice") @Valid NewOnOffAndDimmingDeviceFormDto device,
                                    BindingResult bindingResult,
                                    @PathVariable Long id,
                                    Model model) {
        Integer oldPin = onOffDeviceRepo.findFirstById(id).getPin();
        Integer newPin = device.getPin();

        if (!(oldPin.equals(newPin))) {
            if (!bindingResult.hasErrors() && !pinsService.isPinFree(device.getPin()))
                bindingResult.rejectValue("pin", "", "Ten pin jest już zajęty, ktoś Cię wyprzedził :)");
        }

        if (bindingResult.hasErrors()) {
            List<RaspberryPin> availablePins = pinsService.getAvailablePins();
            model.addAttribute("pinsList", availablePins);
            return "/config/new-onoff-device";
        }

        device.setId(id);
        saveDeviceService.saveOnOffDevice(device);
        return "redirect:/config";
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

        return "redirect:/config";
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
        return "redirect:/config";
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
        return "redirect:/config";
    }

    @GetMapping("/restore")
    public String restoreToDefaultSettingsQuestion() {
        return "/config/restore-default-settings";
    }

    @GetMapping("/restore/yes")
    public String restoreToDefaultSettings() {
        List<OnOffDevice> onOffDevices = onOffDeviceRepo.findAll();
        List<DimmingDevice> dimmingDevices = dimmingDeviceRepo.findAll();

        for (OnOffDevice device : onOffDevices) {
            saveDeviceService.deleteOnOffDevice(device.getId());
        }

        for (DimmingDevice device : dimmingDevices) {
            saveDeviceService.deleteDimmingDevice(device.getId());
        }

        return "redirect:/config";
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


