package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.domain.devices.DeviceDetails;
import pl.coderslab.domain.location.Location;
import pl.coderslab.services.LocationService;
import pl.coderslab.services.ViewService;

import java.util.List;


@Controller
@RequestMapping
public class HomePageController {

    @Autowired
    ViewService viewService;
    @Autowired
    LocationService locationService;

    @GetMapping
    public String homepage(Model model) {
        List<DeviceDetails> devices = viewService.getAllDevicesOrdered();
        model.addAttribute("buttons", devices);
        return "/mainpage/index";
    }

    @ModelAttribute("locations")
    public List<Location> locations() {
        return locationService.getAllLocations();
    }

    @ModelAttribute("menu")
    public Integer menuActive() {
        return 1;
    }
}
