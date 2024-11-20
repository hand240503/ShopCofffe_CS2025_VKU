package com.ndh.CoffeeShop.controller;

import com.ndh.CoffeeShop.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String home(Model model) {

        model.addAttribute("title","Xác nhận đơn hàng");
        return "page/order";
    }
}
