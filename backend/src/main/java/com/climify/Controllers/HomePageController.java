package com.climify.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/climify")
    public String getLandingPage() {
        return "forward:/index.html";
    }
}

