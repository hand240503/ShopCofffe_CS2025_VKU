package com.ndh.CoffeeShop.repository.product;

import com.ndh.CoffeeShop.model.product.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price getPriceById(Long id);
    Price getPriceByProductId(Long productId);
}
