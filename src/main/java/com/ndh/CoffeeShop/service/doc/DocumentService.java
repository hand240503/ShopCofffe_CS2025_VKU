package com.ndh.CoffeeShop.service.doc;

import com.ndh.CoffeeShop.model.doc.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {

    List<Document> reqListDocuments(List<?> lst, int entTyp);
    List<Document> reqListDocuments(Long entId, int entTyp);

}
