package com.ndh.CoffeeShop.controller;

import com.ndh.CoffeeShop.dto.ProductDTO;
import com.ndh.CoffeeShop.repository.product.ProductRepository;
import com.ndh.CoffeeShop.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ProductDTO> lst = productService.getProductsByInfo01(1);
        model.addAttribute("title", "Home");
        model.addAttribute("lst", lst);
        return "page/home";
    }
}