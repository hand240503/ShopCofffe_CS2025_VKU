package com.ndh.CoffeeShop.repository.product;

import com.ndh.CoffeeShop.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> getCategoriesByStatus(int status);
}
