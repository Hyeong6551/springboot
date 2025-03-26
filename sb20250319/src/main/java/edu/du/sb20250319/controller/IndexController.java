package edu.du.sb20250319.controller;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginPost(
            @ModelAttribute UserDto userDto,
            HttpSession session,
            Model model) {
        List<UserTb> user = userService.findAllById(userDto.getId());

        if (!user.isEmpty() && user.get(0).getPassword().equals(userDto.getPassword())) {
            session.setAttribute("user", userDto.getId());
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디나 비밀번호가 일치하지 않습니다.");
            return "user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("userDto") @Valid UserDto userDto,
                               BindingResult bindingResult) {
        if(userService.existsById(userDto)){
            bindingResult.addError(new FieldError("userDto", "id", "해당 아이디가 이미 존재합니다."));
        }
        if(userService.existsByEmail(userDto)){
            bindingResult.addError(new FieldError("userDto", "email", "해당 이메일이 이미 존재합니다."));
        }
        if (bindingResult.hasErrors()) {
            return "user/register";
        }

        UserTb userTb = UserTb.builder()
                .name(userDto.getName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .id(userDto.getId())
                .build();
        userService.save(userTb);
        return "redirect:/";
    }
}
