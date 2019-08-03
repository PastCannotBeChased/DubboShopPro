package com.xy.dubboshoppro.entity;

import java.io.Serializable;

public class TProductType implements Serializable {
    private static final long serialVersionUID = 5483053714886982767L;
    private Long id;

    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}