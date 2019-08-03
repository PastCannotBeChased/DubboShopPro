package com.xy.dubboshoppro.entity;

import java.io.Serializable;

public class TProductDetail implements Serializable {
    private static final long serialVersionUID = 135593387722723250L;
    private Long id;

    private Long tableProductId;

    private Integer tableProductStorage;

    private String tableProductDetail;

    private Long tableProductPrice;

    private Long tableTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableProductId() {
        return tableProductId;
    }

    public void setTableProductId(Long tableProductId) {
        this.tableProductId = tableProductId;
    }

    public Integer getTableProductStorage() {
        return tableProductStorage;
    }

    public void setTableProductStorage(Integer tableProductStorage) {
        this.tableProductStorage = tableProductStorage;
    }

    public String getTableProductDetail() {
        return tableProductDetail;
    }

    public void setTableProductDetail(String tableProductDetail) {
        this.tableProductDetail = tableProductDetail == null ? null : tableProductDetail.trim();
    }

    public Long getTableProductPrice() {
        return tableProductPrice;
    }

    public void setTableProductPrice(Long tableProductPrice) {
        this.tableProductPrice = tableProductPrice;
    }

    public Long getTableTypeId() {
        return tableTypeId;
    }

    public void setTableTypeId(Long tableTypeId) {
        this.tableTypeId = tableTypeId;
    }
}