package com.xy.dubboshoppro.entity;

import java.io.Serializable;

public class TProductBasic implements Serializable {
    private static final long serialVersionUID = 99200037775856759L;
    private Long id;

    private String tableProductName;

    private Long typeId;

    private String tableProductImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableProductName() {
        return tableProductName;
    }

    public void setTableProductName(String tableProductName) {
        this.tableProductName = tableProductName == null ? null : tableProductName.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTableProductImage() {
        return tableProductImage;
    }

    public void setTableProductImage(String tableProductImage) {
        this.tableProductImage = tableProductImage == null ? null : tableProductImage.trim();
    }
}