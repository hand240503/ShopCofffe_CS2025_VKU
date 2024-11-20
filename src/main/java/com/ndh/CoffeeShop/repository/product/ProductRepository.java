package com.ndh.CoffeeShop.repository.product;


import com.ndh.CoffeeShop.model.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> findProductsByCategoryCode(String categoryCode);

    @Query("SELECT p, pr FROM products p " +
            "LEFT JOIN price pr ON pr.product = p " +
            "JOIN p.category c " +
            "WHERE c.code = :categoryCode")
    List<Object[]> findProductsByCategoryCode(@Param("categoryCode") String categoryCode, Pageable pageable);

    @Query("SELECT p, pr FROM products p " +
            "LEFT JOIN price pr ON pr.product = p " +
            "JOIN p.category c " +
            "WHERE c.code = :categoryCode")
    List<Object[]> findProductsByCategoryCode(@Param("categoryCode") String categoryCode);

    List<Product> findProductByInfo01OrderByCreatedDateDesc(int info01, Pageable pageable);

    Product findProductByCode01(String code01);

}
