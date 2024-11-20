package com.ndh.CoffeeShop.dto;

import com.ndh.CoffeeShop.model.doc.Document;
import com.ndh.CoffeeShop.model.product.Category;
import com.ndh.CoffeeShop.model.product.Price;
import com.ndh.CoffeeShop.model.product.Product;
import com.ndh.CoffeeShop.model.product.Unit;
import lombok.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO extends BaseDTO {

    private String code01;
    private String code02;
    private String productName;
    private String status;
    private String description;
    private Category category;
    private Price price;
    private Unit unit;
    private Document avatar;
    private List<Document> doc;

    public static ProductDTO fromProduct(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO dto = ProductDTO.builder()
                .code01(product.getCode01())
                .productName(product.getProductName())
                .status(product.getStatus())
                .description(product.getDescription())
                .category(product.getCategory())
                .build();
        dto.setId(product.getId());
        return dto;
    }

    public static List<ProductDTO> fromLstProduct(List<Product> lst) {
        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.stream()
                .map(ProductDTO::fromProduct)
                .collect(Collectors.toList());
    }

    public static List<ProductDTO> mapProducts(List<Object[]> results) {
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Object[] row : results) {
            Product product = (Product) row[0];
            Price price = (Price) row[1];

            ProductDTO dto = ProductDTO.builder()
                    .code01(product.getCode01())
                    .productName(product.getProductName())
                    .description(product.getDescription())
                    .status(product.getStatus())
                    .price(price)
                    .unit(price != null ? price.getUnit() : null)
                    .build();
            dto.setId(product.getId());
            productDTOs.add(dto);
        }
        return productDTOs;
    }
}
