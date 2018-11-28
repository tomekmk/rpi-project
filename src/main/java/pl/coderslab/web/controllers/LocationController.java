package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.domain.location.Location;
import pl.coderslab.services.LocationService;
import pl.coderslab.web.dtos.LocationFormDTO;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping
    public String getLocations(Model model) {
        model.addAttribute("newLocation", new LocationFormDTO());
        return "/locations/location-form";
    }

    @PostMapping
    public String addNewLocation(@ModelAttribute("newLocation") @Valid LocationFormDTO location,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors())
            return "/locations/location-form";

        locationService.saveLocation(location);
        return "redirect:/location";
    }

    @ModelAttribute("locations")
    public List<Location> locations(Model model) {
        List<Location> allLocations = locationService.getAllLocations();
        if (allLocations.size() == 0)
            model.addAttribute("isAnyLocations", false);
        else
            model.addAttribute("isAnyLocations", true);

        return allLocations;
    }

    @ModelAttribute("menu")
    public Integer menuActive() {
        return 2;
    }
}
