package edu.du.sb20250319.controller;

import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import edu.du.sb20250319.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/list")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Model model) {
        List<UserTb> user = userService.findAll();
        System.out.println(user);
        model.addAttribute("users", user);
        return "user/userlist";
    }

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable int no, Model model) {
        UserTb user = userService.findAllByNo(no);
        model.addAttribute("userDto",user);
        return  "user/edit";
    }

    @PostMapping("/edit/{no}")
    public String edit(@PathVariable int no, @ModelAttribute UserDto userDto) {
        userService.updateUser(no, userDto);
        return "redirect:/list";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable int no) {
        userService.deleteByNo(no);
        return  "redirect:/list";
    }
}
