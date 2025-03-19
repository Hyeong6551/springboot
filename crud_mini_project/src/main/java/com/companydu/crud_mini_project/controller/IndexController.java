package com.companydu.crud_mini_project.controller;

import com.companydu.crud_mini_project.entity.UsersDto;
import com.companydu.crud_mini_project.service.GoodsService;
import com.companydu.crud_mini_project.service.UsersService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private final GoodsService goodsService;
    private final UsersService usersService;

    public IndexController(GoodsService goodsService, UsersService usersService) {
        this.goodsService = goodsService;
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("goods", goodsService.selectAllGoods());
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "board/login/loginForm";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("usersDto", new UsersDto());
        return "board/login/registerForm";
    }

    @PostMapping("/registerSuccess")
    public String registerSuccess(UsersDto usersDto,Model model) {
        usersService.insertUser(usersDto);
        model.addAttribute("usersDto", usersDto);
        return "board/login/registerSuccess";
    }
}
