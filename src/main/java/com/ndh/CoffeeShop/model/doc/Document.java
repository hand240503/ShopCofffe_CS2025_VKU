package com.ndh.CoffeeShop.model.doc;

import com.ndh.CoffeeShop.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "document")
public class Document extends BaseEntity {

    public static final String COL_FILE_NAME            = "file_name";
    public static final String COL_FILE_SIZE            = "file_size";
    public static final String COL_FILE_PATH            = "file_path";
    public static final String COL_TYPE_01              = "type_01";
    public static final String COL_TYPE_02              = "type_02";
    public static final String COL_FILE_DES             = "file_des";
    public static final String COL_ENTITY_ID            = "entity_id";
    public static final String COL_DESCRIPTION          = "description";
    public static final String COL_ENTITY_TYPE          = "entity_type";

    @Column(name = COL_FILE_NAME, nullable = true)
    private String      fileName;

    @Column(name = COL_FILE_SIZE, nullable = true)
    private String      fileSize;

    @Column(name = COL_FILE_PATH, nullable = true)
    private String      filePath;

    @Column(name = COL_TYPE_01, nullable = true)
    private int         type_01;
    @Column(name = COL_TYPE_02, nullable = true)
    private int         type_02;

    @Column(name = COL_FILE_DES, nullable = true)
    private String      fileDes;

    @Column(name = COL_ENTITY_ID, nullable = true)
    private Long        entityId;

    @Column(name = COL_DESCRIPTION, nullable = true)
    private String      description;

    @Column(name = COL_ENTITY_TYPE, nullable = true)
    private Integer     entityType;
}
