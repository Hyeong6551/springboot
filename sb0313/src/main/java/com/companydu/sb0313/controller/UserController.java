package com.companydu.sb0313.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String showForm() {
        return "index";  // index.jsp를 반환
    }
}
