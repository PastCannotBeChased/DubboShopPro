package com.xy.shoppro.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xy.shoppro.common.base.IBaseDao;
import com.xy.shoppro.common.impl.BaseServiceImpl;
import com.xy.shoppro.entity.TProductType;
import com.xy.shoppro.mapper.TProductTypeMapper;
import com.xy.shoppro.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author SYQ
 * Created on 2019\8\8 0008 21:20
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@Service
public class ProductTypeServiceImpl extends BaseServiceImpl<TProductType> implements IProductTypeService {

    @Autowired
    private TProductTypeMapper productTypeMapper;
    @Override
    public IBaseDao<TProductType> getBaseDao() {
        return productTypeMapper;
    }
}
