package com.xy.shoppro.common.pojo;

/**
 * @author SYQ
 * Created on 2019\8\6 0006 16:46
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public class ResultBean<T> {

    private Integer statusCode;

    private T data;

    public ResultBean() {
    }

    public ResultBean(Integer statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
