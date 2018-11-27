package pl.coderslab.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class HomePageController {

    @GetMapping
    public String homepage() {
        return "/mainpage/index";
    }
}
