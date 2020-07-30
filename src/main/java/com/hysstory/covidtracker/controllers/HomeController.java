package com.hysstory.covidtracker.controllers;

import com.hysstory.covidtracker.models.LocationStats;
import com.hysstory.covidtracker.services.CovidDataService;
import jdk.jshell.execution.LoaderDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    private CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> stats = covidDataService.getAllStats();
        int totalCases = stats.stream().mapToInt(LocationStats::getCases).sum();
        String numberFormat =
                NumberFormat
                        .getNumberInstance(Locale.US)
                        .format(totalCases);
        model.addAttribute("stats", stats);
        model.addAttribute("totalCases", numberFormat);
        return "index";
    }
}
