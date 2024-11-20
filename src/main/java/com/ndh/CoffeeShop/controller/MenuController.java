package com.ndh.CoffeeShop.controller;

import com.ndh.CoffeeShop.dto.ProductDTO;
import com.ndh.CoffeeShop.model.doc.Document;
import com.ndh.CoffeeShop.model.product.Category;
import com.ndh.CoffeeShop.service.doc.DocumentService;
import com.ndh.CoffeeShop.service.product.CategoryService;
import com.ndh.CoffeeShop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MenuController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final DocumentService documentService;

    @Autowired
    public MenuController(CategoryService categoryService, ProductService productService, DocumentService documentService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.documentService = documentService;
    }

    @GetMapping("/collections/{type}")
    public String home(@PathVariable String type, Model model) {
        if (type == null || type.isEmpty()) {
            model.addAttribute("error", "Category type cannot be null or empty");
            return "page/home";
        }

        List<Category> lstCat = categoryService.getCategoriesByStatus(1);
        List<ProductDTO> lstProductDTOS = null;
        boolean isValidCategory = lstCat.stream()
                .anyMatch(cat -> cat.getName().equalsIgnoreCase(type));
        if (isValidCategory) {
            lstProductDTOS = productService.getProductsByCategoryCode(type);
        }

        model.addAttribute("title", "Menu");
        model.addAttribute("lstCat", lstCat);
        model.addAttribute("lstProduct", lstProductDTOS);
        return "page/menu";
    }
}