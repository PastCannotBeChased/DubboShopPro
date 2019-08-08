package com.xy.shoppro.service;

import com.github.pagehelper.PageInfo;
import com.xy.shoppro.entity.TProduct;
import com.xy.shoppro.common.base.IBaseService;
import com.xy.shoppro.vo.ProductVO;

import java.util.List;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:30
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
public interface IProductService extends IBaseService<TProduct> {
    String hello(String name);
    TProduct getProductById(Long id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TProduct> page(Integer pageNum,Integer pageSize);
    /**
     * 商品添加
     * 有主键返回
     * @return
     */
    Long add(ProductVO productVO);

    /**
     * 商品修改回显
     * @param id
     * @return
     */
    ProductVO toModify(Long id);

    /**
     * 修改商品
     * @param product
     * @return
     */
    int updateProduct(ProductVO product);

    int delProductById(Long id);

    int delProductsByIds(List<Long> ids);
}
