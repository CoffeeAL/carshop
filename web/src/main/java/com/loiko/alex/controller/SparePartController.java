package com.loiko.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SparePartController {

    @GetMapping("/spareparts")
    public String allSpareParts(Model model) {
        return null;
    }

}