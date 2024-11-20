package com.ndh.CoffeeShop.repository.product;

import com.ndh.CoffeeShop.model.product.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit getUnitById(Long id);
}
