package com.xy.shoppro.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.shoppro.common.base.IBaseDao;
import com.xy.shoppro.common.impl.BaseServiceImpl;
import com.xy.shoppro.entity.TProduct;
import com.xy.shoppro.entity.TProductDesc;
import com.xy.shoppro.mapper.TProductDescMapper;
import com.xy.shoppro.mapper.TProductMapper;
import com.xy.shoppro.service.IProductService;
import com.xy.shoppro.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:31
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<TProduct> implements IProductService {

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private TProductDescMapper productDescMapper;

    @Override
    public IBaseDao<TProduct> getBaseDao() {
        return productMapper;
    }

    @Override
    public String hello(String name) {
        return "Hello!"+name;
    }

    @Override
    public TProduct getProductById(Long id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TProduct> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TProduct> list =getBaseDao().list();
        PageInfo<TProduct> pageInfo=new PageInfo<>(list,5);
        return pageInfo;
    }

    /**
     * 添加商品
     * @param productVO
     * @return
     */
    @Override
    @Transactional
    public Long add(ProductVO productVO) {
        //先往商品表中添加
        TProduct product=productVO.getProduct();
        product.setTypeId(1L);
        int i = productMapper.insertSelective(product);
        TProductDesc productDesc=new TProductDesc();
        productDesc.setDetail(productVO.getProductDesc());
        productDesc.setPid(product.getId());
        productDescMapper.insertSelective(productDesc);
        return product.getId();
    }

    @Override
    public ProductVO toModify(Long id) {
        TProduct product=productMapper.selectByPrimaryKey(id);
        TProductDesc productDesc=productDescMapper.selectByPid(id);
        ProductVO productVO=new ProductVO();
        productVO.setProduct(product);
        if(null !=productDesc){
            productVO.setProductDesc(productDesc.getDetail());
        }
        return productVO;
    }

    @Override
    @Transactional
    public int updateProduct(ProductVO product) {
        TProduct product1 = product.getProduct();
        TProductDesc desc=new TProductDesc();
        desc.setPid(product1.getId());
        desc.setDetail(product.getProductDesc());
        productMapper.updateByPrimaryKeySelective(product1);
        int i=productDescMapper.updateByPidSelective(desc);
        return i;
    }

    /**
     * 单个删除(时及时修改flag为0）
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int delProductById(Long id) {
        Boolean flag=false;
        int result=productMapper.updateFlagById(id,flag);
        return result;
    }

    /**
     * 批量删除(须同时删除商品表以及对应的商品描述表）
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public int delProductsByIds(List<Long> ids) {
        Boolean flag=false;
        int result=productMapper.updateFlagByIds(ids,flag);
        return result;
    }
}
