package com.it.service;

import com.google.common.collect.Maps;
import com.it.mapper.CustomerMapper;
import com.it.pojo.Customer;
import com.it.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
@Named
public class CustomerService {
    @Inject
    private CustomerMapper customerMapper;
    public List<Customer> findCustomerByParams(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());

        }
        return customerMapper.findByParam(params);
    }

    public Long count(){
        if(ShiroUtil.isEmployee()){
            Map<String,Object> params = Maps.newHashMap();
            params.put("userid",ShiroUtil.getCurrentUserID());
            return customerMapper.countByParam(params);
        }
        return customerMapper.count();
    }
    public Long countByParam(Map<String,Object> parms){
        if(ShiroUtil.isEmployee()){
            parms.put("userid",ShiroUtil.getCurrentUserID());
        }
        return customerMapper.countByParam(parms);
    }
}
