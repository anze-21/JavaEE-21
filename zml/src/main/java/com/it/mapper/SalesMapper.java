package com.it.mapper;

import com.it.pojo.Sales;

import java.util.List;
import java.util.Map;

public interface SalesMapper {
    List<Sales> findByParam(Map<String, Object> params);

    Long countByParam(Map<String, Object> params);

    void save(Sales sales);

    List<Sales> findByCustId(Integer custId);
}