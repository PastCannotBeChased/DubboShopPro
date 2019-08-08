package com.xy.shoppro.common.impl;

import com.xy.shoppro.common.base.IBaseDao;
import com.xy.shoppro.common.base.IBaseService;

import java.util.List;

/**
 * @author SYQ
 * Created on 2019\8\5 0005 12:05
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseDao<T> getBaseDao();

    public int deleteByPrimaryKey(Long id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    public int insert(T record) {
        return getBaseDao().insert(record);
    }

    public int insertSelective(T record) {
        return getBaseDao().insertSelective(record);
    }

    public T selectByPrimaryKey(Long id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T record) {
        return getBaseDao().updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(T record) {
        return getBaseDao().updateByPrimaryKey(record);
    }

    public List<T> list() {
        return getBaseDao().list();
    }
}
