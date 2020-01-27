package com.example.bank.demoqub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by michael on 25/01/2020.
 */
@Controller
public class WebAppController {

    @Value("${spring.application.name}")
    String appName;

    int amount = 50;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("username", "student-1");
        model.addAttribute("amount", amount);
        return "index";
    }

}
