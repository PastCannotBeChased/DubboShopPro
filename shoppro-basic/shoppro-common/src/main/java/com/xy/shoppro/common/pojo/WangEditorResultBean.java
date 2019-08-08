package com.xy.shoppro.common.pojo;

import java.io.Serializable;

/**
 * @author SYQ
 * Created on 2019\8\7 0007 21:07
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public class WangEditorResultBean implements Serializable {

    private static final long serialVersionUID = 2612178273327802765L;

    private String errno;
    private String [] data;

    public WangEditorResultBean() {
    }

    public WangEditorResultBean(String errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
