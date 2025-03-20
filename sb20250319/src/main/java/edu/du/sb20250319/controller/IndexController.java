package edu.du.sb20250319.controller;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.repository.UserTbRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserTbRepo userTbRepo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(
            @ModelAttribute UserDto userDto,
            HttpSession session,
            Model model) {
        List<UserTb> user = userTbRepo.findAllById(userDto.getId());

        if (!user.isEmpty() && user.get(0).getPassword().equals(userDto.getPassword())) {
            session.setAttribute("user", userDto.getId());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
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
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("userDto") @Valid UserDto userDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        UserTb userTb = UserTb.builder()
                .name(userDto.getName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .id(userDto.getId())
                .build();
        userTbRepo.save(userTb);
        return "redirect:/";
    }
}
