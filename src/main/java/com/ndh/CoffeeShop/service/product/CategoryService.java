package com.ndh.CoffeeShop.service.product;

import com.ndh.CoffeeShop.model.product.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

   List<Category> getAllCategories();

   List<Category> getCategoriesByStatus(int status);
}
