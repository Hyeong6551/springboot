package edu.du.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GatewayController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/board")
    public String board() {
        return "board";
    }
}
