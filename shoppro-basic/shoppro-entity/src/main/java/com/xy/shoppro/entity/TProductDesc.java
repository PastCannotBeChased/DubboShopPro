package com.xy.shoppro.entity;

import java.io.Serializable;

public class TProductDesc implements Serializable {
    private static final long serialVersionUID = -421583410908491284L;
    private Long id;

    private Long pid;

    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}