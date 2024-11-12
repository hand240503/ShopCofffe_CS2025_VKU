package com.ndh.CoffeeShop.model.product;

import com.ndh.CoffeeShop.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "price")
public class Price extends BaseEntity {

    public static final String COL_CURRENT_VALUE   = "current_value";
    public static final String COL_OLD_VALUE       = "old_value";
    public static final String COL_PRODUCT_ID      = "product_id";
    public static final String COL_UNIT_ID         = "unit_id";

    @Column(name = COL_CURRENT_VALUE, nullable = false)
    private Double currentValue;

    @Column(name = COL_OLD_VALUE, nullable = false)
    private String oldValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_UNIT_ID, nullable = false)
    private Unit unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_PRODUCT_ID, nullable = false)
    private Product product;
}