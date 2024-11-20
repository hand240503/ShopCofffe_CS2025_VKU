package com.ndh.CoffeeShop.service.product;

import com.ndh.CoffeeShop.dto.ProductDTO;
import com.ndh.CoffeeShop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<ProductDTO> getProductsByCategoryCode(String category);

    List<ProductDTO> getProductsByInfo01(int info01);

    ProductDTO getProductByCode01(String code01);
}
