package com.hysstory.covidtracker.controllers;

import com.hysstory.covidtracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("stats", covidDataService.getAllStats());
        return "index";
    }
}
