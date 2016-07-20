package com.it.mapper;

import com.it.pojo.SalesLog;

import java.util.List;

public interface SalesLogMapper {
    void save(SalesLog salesLog);

    List<SalesLog> findBySalesId(Integer salesId);

    void del(List<SalesLog> salesLogList);
}
