package com.ndh.CoffeeShop.service.doc.impl;

import com.ndh.CoffeeShop.dto.BaseDTO;
import com.ndh.CoffeeShop.model.BaseEntity;
import com.ndh.CoffeeShop.model.doc.Document;
import com.ndh.CoffeeShop.model.product.Product;
import com.ndh.CoffeeShop.repository.doc.DocumentRepository;
import com.ndh.CoffeeShop.service.doc.DocumentService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> reqListDocuments(List<?> lst, int entTyp) {
        if (lst == null || lst.isEmpty()) {
            return Collections.emptyList();
        }
        Set<Long> ids = lst.stream()
                .map(item -> {
                    BaseDTO ent = (BaseDTO) item;
                    return ((BaseDTO) item).getId();
                })
                .collect(Collectors.toSet());
        return documentRepository.reqlist(ids, 20100, 2, 1);
    }

    @Override
    public List<Document> reqListDocuments(Long entId, int entTyp) {
        return documentRepository.reqlist(entId, 20100, 2, 1);
    }

    public static void doBuildAvatarForList(List<Product> lst) {
        if (lst == null || lst.isEmpty()) return;
    }
}
