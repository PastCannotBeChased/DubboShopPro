package com.xy.dubboshoppro.service;

import com.xy.dubboshoppro.entity.TProductBasic;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:30
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public interface IProductService {
    String hello(String name);
    TProductBasic getProductById(Long id);
}
