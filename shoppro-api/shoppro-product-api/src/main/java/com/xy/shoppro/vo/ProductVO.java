package com.xy.shoppro.vo;

import com.xy.shoppro.entity.TProduct;

import java.io.Serializable;

/**
 * @author SYQ
 * Created on 2019\8\6 0006 10:54
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public class ProductVO implements Serializable {
    private static final long serialVersionUID = -2697318554152141261L;
    private TProduct product;
    private String productDesc;

    public TProduct getProduct() {
        return product;
    }

    public void setProduct(TProduct product) {
        this.product = product;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
