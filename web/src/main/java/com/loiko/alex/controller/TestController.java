package com.loiko.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Controller
public class TestController {

    @GetMapping("/test")
    public String getTest() {
        return "test";
    }
}
