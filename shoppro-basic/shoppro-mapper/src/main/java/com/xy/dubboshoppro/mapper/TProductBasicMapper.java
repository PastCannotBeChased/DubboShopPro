package com.xy.dubboshoppro.mapper;

import com.xy.dubboshoppro.entity.TProductBasic;

public interface TProductBasicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TProductBasic record);

    int insertSelective(TProductBasic record);

    TProductBasic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TProductBasic record);

    int updateByPrimaryKey(TProductBasic record);
}