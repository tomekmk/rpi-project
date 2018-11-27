package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dal.repositories.DeviceRepo;
import pl.coderslab.domain.devices.OnOffDevice;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomePageController {

    @Autowired
    DeviceRepo<OnOffDevice> deviceRepo;

    @GetMapping
    public String homepage() {
        return "index";
    }

    @GetMapping("/temp")
    public String addNewTypeDeviceForm(Model model) {
        model.addAttribute("deviceType", devices());     //todo: return correct object after choose device type
        return "new-device-form";
    }

    @PostMapping
    public String addNewDevice(@RequestParam String type,
                               Model model) {
        if (type.equals("onoff")) {
            model.addAttribute("newDevice", new OnOffDevice());
            model.addAttribute("typeNumber", 1);
            return "/new-onoff-device";
        }
        return "/new-onoff-device";
    }

    @PostMapping("/addnew/{type}")
    public String addNewDevice(@PathVariable Integer type,
                               @ModelAttribute("newDevice") OnOffDevice device) {
        if (type == 1) {
            deviceRepo.save(device);
        }


//        if (device instanceof OnOffDevice) {
//            OnOffDevice device1 = (OnOffDevice) device;
//            deviceRepo.save(device1);
//        }
        return "redirect:/";
    }

    private List<String> devices() {
        return Arrays.asList("onoff", "dimming");
    }
}
