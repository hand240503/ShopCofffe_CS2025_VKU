package com.ndh.CoffeeShop.controller;

import com.ndh.CoffeeShop.dto.ProductDTO;
import com.ndh.CoffeeShop.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{code}")
    public String home(@PathVariable String code, Model model) {
        if (code == null || code.isEmpty()) {
            model.addAttribute("error", "Category type cannot be null or empty");
            return "page/home";
        }

        ProductDTO product = productService.getProductByCode01(code);
        model.addAttribute("product", product);
        return "page/product";
    }
}
