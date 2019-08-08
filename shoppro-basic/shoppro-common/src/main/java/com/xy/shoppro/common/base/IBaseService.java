package com.xy.shoppro.common.base;

import java.util.List;

/**
 * @author SYQ
 * Created on 2019\8\5 0005 12:03
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public interface IBaseService<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);


    int updateByPrimaryKey(T record);

    List<T> list();
}
