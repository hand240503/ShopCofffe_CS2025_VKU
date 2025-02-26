package com.ndh.CoffeeShop.model.config;

import com.ndh.CoffeeShop.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "config")
public class Config extends BaseEntity {

    public static final String COL_NAME             = "name";
    public static final String COL_CODE             = "code";
    public static final String COL_VALUE_CONFIG     = "value_config";

    @Column(name = COL_NAME, nullable = true)
    private String name;

    @Column(name = COL_CODE, nullable = true)
    private String code;

    @Column(name = COL_VALUE_CONFIG, nullable = true)
    private String value_config;
}
