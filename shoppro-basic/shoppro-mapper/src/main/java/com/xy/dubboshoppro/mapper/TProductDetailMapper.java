package com.xy.dubboshoppro.mapper;

import com.xy.dubboshoppro.entity.TProductDetail;

public interface TProductDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TProductDetail record);

    int insertSelective(TProductDetail record);

    TProductDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TProductDetail record);

    int updateByPrimaryKey(TProductDetail record);
}