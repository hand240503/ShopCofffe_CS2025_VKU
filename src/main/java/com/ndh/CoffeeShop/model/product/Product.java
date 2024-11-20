package com.ndh.CoffeeShop.model.product;

import com.ndh.CoffeeShop.model.BaseEntity;
import com.ndh.CoffeeShop.model.doc.Document;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "products")
public class Product extends BaseEntity {

    public static final String COL_PRODUCT_NAME = "product_name";
    public static final String COL_STATUS = "status";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_CATEGORY_ID = "category_id";
    public static final String COL_PRODUCT_ID = "product_id";
    public static final String COL_INFO_01 = "info_01";
    public static final String COL_INFO_02 = "info_02";
    public static final String COL_INFO_03 = "info_03";
    public static final String COL_INFO_04 = "info_04";
    public static final String COL_CODE_01 = "code_01";
    public static final String COL_CODE_02 = "code_02";

    @Column(name = COL_PRODUCT_NAME, nullable = true)
    private String productName;

    @Column(name = COL_STATUS, nullable = true)
    private String status;

    @Column(name = COL_DESCRIPTION, nullable = true)
    private String description;

    @Column(name = COL_CODE_01, nullable = true)
    private String code01;

    @Column(name = COL_CODE_02, nullable = true)
    private String code02;

    @Column(name = COL_INFO_01, nullable = true)
    private Integer info01;

    @Column(name = COL_INFO_02, nullable = true)
    private Integer info02;

    @Column(name = COL_INFO_03, nullable = true)
    private Integer info03;

    @Column(name = COL_INFO_04, nullable = true)
    private Integer info04;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_CATEGORY_ID, nullable = false)
    private Category category;

    @Transient
    private Document O_Avatar = null;

}
