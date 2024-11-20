package com.ndh.CoffeeShop.service.product.impl;

import com.ndh.CoffeeShop.model.product.Category;
import com.ndh.CoffeeShop.repository.product.CategoryRepository;
import com.ndh.CoffeeShop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getCategoriesByStatus(int status) {
        return categoryRepository.getCategoriesByStatus(status);
    }
}
