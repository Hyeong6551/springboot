package com.companydu.crud_mini_project.controller;

import com.companydu.crud_mini_project.entity.GoodsDto;
import com.companydu.crud_mini_project.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goods")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/{id}")
    public String goodsController(@PathVariable int id, Model model) {
        model.addAttribute("goods", goodsService.selectGoods(id));
        return "goods/goods";
    }

    @GetMapping("write")
    public String insert(Model model) {
        return "goods/goodsCreateForm";
    }

    @PostMapping("write")
    public String insert(Model model, GoodsDto goodsDto) {
        model.addAttribute("goods", goodsService.insertGoods(goodsDto));
        return "redirect:/goods";
    }
}
