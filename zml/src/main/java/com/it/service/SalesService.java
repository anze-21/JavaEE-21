package com.it.service;

import com.google.common.collect.Maps;
import com.it.mapper.CustomerMapper;
import com.it.mapper.SalesFileMapper;
import com.it.mapper.SalesLogMapper;
import com.it.mapper.SalesMapper;
import com.it.pojo.Sales;
import com.it.pojo.SalesLog;
import com.it.util.ShiroUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Named
public class SalesService {
    @Inject
    private SalesMapper salesMapper;
    @Inject
    private SalesFileMapper salesFileMapper;
    @Inject
    private SalesLogMapper salesLogMapper;
    @Inject
    private CustomerMapper customerMapper;

    public List<Sales> findByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.findByParam(params);
    }


    public Long count() {
        Map<String,Object> params = Maps.newHashMap();
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(params);
    }

    public Long countByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(params);

    }

    /**
     * 新增销售机会
     * @param sales
     */
    @Transactional
    public void saveSales(Sales sales) {
        sales.setUserid(ShiroUtil.getCurrentUserID());
        sales.setUsername(ShiroUtil.getCurrentRealName());
        sales.setCustname(customerMapper.findById(sales.getCustid()).getName());
        salesMapper.save(sales);
        //自动产生创建日志
        SalesLog salesLog = new SalesLog();
        salesLog.setType(SalesLog.LOG_TYPE_AUTO);
        salesLog.setContext(ShiroUtil.getCurrentRealName() + "创建了该销售的机会");
        salesLog.setSalesid(sales.getId());
        salesLogMapper.save(salesLog);
    }
}
