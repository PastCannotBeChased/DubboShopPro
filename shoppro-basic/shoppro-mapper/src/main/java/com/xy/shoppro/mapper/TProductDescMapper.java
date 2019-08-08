package com.xy.shoppro.mapper;

import com.xy.shoppro.entity.TProductDesc;
import com.xy.shoppro.common.base.IBaseDao;

import java.util.List;

public interface TProductDescMapper extends IBaseDao<TProductDesc> {
    TProductDesc selectByPid(Long pid);

    int updateByPidSelective(TProductDesc desc);

    int deleteByPid(Long pid);

    int deleteByPids(List<Long> pids);
}