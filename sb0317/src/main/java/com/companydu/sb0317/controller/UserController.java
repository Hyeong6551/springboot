package com.companydu.sb0317.controller;

import com.companydu.sb0317.spring.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class UserController {
    @GetMapping
    public String user() {
        return "user/success";
    }

    @GetMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
            Model model) {
        if (!agree) {
            return "register/step1";
        } else {
            model.addAttribute("registerRequest", new RegisterRequest());
            return "register/step2";
        }
    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest registerRequest,
                              Model model) {
//        파라미터에 쓰거나 model.addAttribute로 추가 하거나 둘 중하나로
//        파라미터에 @ModelAttribute 생략
//        메서드 위에 @ModelAttribute 사용 가능
//        model.addAttribute("registerRequest", registerRequest);
        return "register/result";
    }
}
