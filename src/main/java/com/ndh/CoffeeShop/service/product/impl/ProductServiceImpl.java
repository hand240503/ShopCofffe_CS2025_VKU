package com.ndh.CoffeeShop.service.product.impl;

import com.ndh.CoffeeShop.dto.BaseDTO;
import com.ndh.CoffeeShop.dto.ProductDTO;
import com.ndh.CoffeeShop.model.doc.Document;
import com.ndh.CoffeeShop.model.product.Price;
import com.ndh.CoffeeShop.model.product.Product;
import com.ndh.CoffeeShop.repository.doc.DocumentRepository;
import com.ndh.CoffeeShop.repository.product.PriceRepository;
import com.ndh.CoffeeShop.repository.product.ProductRepository;
import com.ndh.CoffeeShop.repository.product.UnitRepository;
import com.ndh.CoffeeShop.service.doc.DocumentService;
import com.ndh.CoffeeShop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final UnitRepository unitRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, UnitRepository unitRepository, DocumentRepository documentRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.unitRepository = unitRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<ProductDTO> getProductsByCategoryCode(String code) {
        List<Object[]> results = productRepository.findProductsByCategoryCode(code);
        List<ProductDTO> products = ProductDTO.mapProducts(results);

        doBuildAvatar(products);
        return products;
    }

    public void doBuildAvatar(List<ProductDTO> lst) {

        if (lst == null || lst.isEmpty()) return;
        Map<Long, Document> mapAva = new HashMap<>();
        Set<Long> ids = lst.stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toSet());
        List<Document> lstAva = documentRepository.reqlist(ids, 20100, 2, 1);
        if (lstAva != null && !lstAva.isEmpty()) {
            for (Document a : lstAva) {
                mapAva.put(a.getEntityId(), a);
            }
            for (ProductDTO p : lst) {
                Long id = p.getId();
                if (mapAva.containsKey(id))
                    p.setAvatar(mapAva.get(id));
            }
        }

    }

    public void doBuildAvatar(ProductDTO productDTO) {
        if (productDTO == null || productDTO.getId() == null) {
            return;
        }

        Long productId = productDTO.getId();
        List<Document> lstAva = documentRepository.reqlist(
                productId,
                20100,
                2,
                1
        );

        if (lstAva != null && !lstAva.isEmpty()) {
            productDTO.setAvatar(lstAva.get(0));
        }
    }

    @Override
    public List<ProductDTO> getProductsByInfo01(int info01) {
        List<ProductDTO> lstDto = null;
        Pageable pageable = PageRequest.of(0, 6);
        List<Product> lst = productRepository.findProductByInfo01OrderByCreatedDateDesc(info01, pageable);
        if (lst != null)
            lstDto = ProductDTO.fromLstProduct(lst);

        doBuildAvatar(lstDto);
        return lstDto;
    }

    @Override
    public ProductDTO getProductByCode01(String code01) {
        ProductDTO productDTO = null;
        Product product = productRepository.findProductByCode01(code01);


        if (product != null) {
            Price price = priceRepository.getPriceByProductId(product.getId());
            productDTO = ProductDTO.fromProduct(product);
            productDTO.setPrice(price);
            productDTO.setUnit(price.getUnit());
        }

        doBuildAvatar(productDTO);
        return productDTO;
    }
}
