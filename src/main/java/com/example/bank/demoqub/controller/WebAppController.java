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
        model.addAttribute("username", "student-1");
        model.addAttribute("amount", amount);
        return "index";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        amount = amount - 10;
        return homePage(model);
    }

    @GetMapping("/receive")
    public String receive(Model model) {
        if(amount >= 100) {
            return error(model);
        }
        amount = amount + 10;
        return homePage(model);
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("username", "student-1");
        return "error";
    }

}
