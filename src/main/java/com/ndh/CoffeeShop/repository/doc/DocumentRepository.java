package com.ndh.CoffeeShop.repository.doc;

import com.ndh.CoffeeShop.model.doc.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("SELECT doc FROM document doc WHERE doc.entityId = :entityId AND doc.entityType = :entityType AND doc.type_01 = :type01 AND doc.type_02 = :type02")
    List<Document> reqlist(@Param("entityId") Long entityId,
                           @Param("entityType") Integer entityType,
                           @Param("type01") Integer type01,
                           @Param("type02") Integer type02);

    @Query("SELECT doc FROM document doc WHERE doc.entityId IN :entityIds AND doc.entityType = :entityType AND doc.type_01 = :type01 AND doc.type_02 = :type02")
    List<Document> reqlist(@Param("entityIds") Set<Long> entityIds,
                                      @Param("entityType") Integer entityType,
                                      @Param("type01") Integer type01,
                                      @Param("type02") Integer type02);
}

