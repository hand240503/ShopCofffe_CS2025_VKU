package com.ndh.CoffeeShop.model.order;

import com.ndh.CoffeeShop.model.BaseEntity;
import com.ndh.CoffeeShop.model.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "order_detail")
public class OrderDetail extends BaseEntity {

    public static final String COL_DESCRIPTION      = "description";
    public static final String COL_QUANTITY         = "quantity";
    public static final String COL_TOTAL_PRICE      = "total_price";
    public static final String COL_ORDER_ID         = "order_id";
    public static final String COL_PRODUCT_ID       = "product_id";

    @Column(name = COL_DESCRIPTION, nullable = true)
    private String description;

    @Column(name = COL_QUANTITY, nullable = true)
    private Integer quantity;

    @Column(name = COL_TOTAL_PRICE, nullable = true)
    private String totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_ORDER_ID, nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_PRODUCT_ID, nullable = false)
    private Product product;

}
