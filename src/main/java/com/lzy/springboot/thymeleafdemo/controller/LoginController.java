package com.lzy.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "login";
    }
    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "access-denied";
    }

}
