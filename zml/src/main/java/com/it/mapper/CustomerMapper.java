package com.it.mapper;

import com.it.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper  {
    List<Customer> findByParam(Map<String,Object> params);
    Long count();
    Long countByParam(Map<String,Object> params);
}
