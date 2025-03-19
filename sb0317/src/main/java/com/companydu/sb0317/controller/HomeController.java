package com.companydu.sb0317.controller;

import com.companydu.sb0317.spring.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
//  @RequestMapping(value="/", method=RequestMethod.GET)
    @GetMapping("/")
    public String home() {
        return "success";
    }
}
