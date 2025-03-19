package com.companydu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
    	// redirect 안하고 sendRedirect
        return "redirect:/tasks";
    }
} 

//  / 를 dispatcherServlet이 받음