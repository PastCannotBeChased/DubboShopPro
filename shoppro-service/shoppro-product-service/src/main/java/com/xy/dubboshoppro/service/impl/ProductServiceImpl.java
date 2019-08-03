package com.xy.dubboshoppro.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xy.dubboshoppro.entity.TProductBasic;
import com.xy.dubboshoppro.mapper.TProductBasicMapper;
import com.xy.dubboshoppro.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:31
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private TProductBasicMapper productBasicMapper;

    @Override
    public String hello(String name) {
        return "Hello!"+name;
    }

    @Override
    public TProductBasic getProductById(Long id) {
        return productBasicMapper.selectByPrimaryKey(id);
    }
}
