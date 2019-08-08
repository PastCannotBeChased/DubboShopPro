package com.xy.shoppro.mapper;

import com.xy.shoppro.common.base.IBaseDao;
import com.xy.shoppro.entity.TProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductMapper extends IBaseDao<TProduct> {
    int deleteByPrimaryKeys(List<Long> ids);

    int updateFlagById(@Param("id") Long id,@Param("flag") Boolean flag);

    int updateFlagByIds(@Param("list") List<Long> ids,@Param("flag") Boolean flag);
}