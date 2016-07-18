package com.it.mapper;

import com.it.pojo.Customer;
import java.util.List;
import java.util.Map;

public interface CustomerMapper  {
    List<Customer> findByParam(Map<String,Object> params);
    Long count();
    Long countByParam(Map<String,Object> params);
    Customer findById(Integer id);

    List<Customer> findByType(String Type);
    void save(Customer customer);
    List<Customer> findCompanyLikeName(String keyword);

    List<Customer> findByCompanyId(Integer id);

    void update(Customer cust);

    void del(Integer id);

    List<Customer> findAll(Integer userid);
}
