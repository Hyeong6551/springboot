package edu.du.sb0327.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembersController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
