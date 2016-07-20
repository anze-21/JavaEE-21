package com.it.mapper;

import com.it.pojo.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SalesMapper {
    List<Sales> findByParam(Map<String, Object> params);

    Long countByParam(Map<String, Object> params);

    void save(Sales sales);

    List<Sales> findByCustId(Integer custId);

    Sales findById(Integer id);

    void update(Sales sales);

    void del(Integer id);

    Long findStateCount(@Param("start") String start, @Param("end") String end, @Param("state") String state);

    Float findStateMoney(@Param("start") String start, @Param("end") String end, @Param("state") String state);

    List<Map<String, Object>> countProgress(@Param("start") String start, @Param("end") String end);

    List<Map<String, Object>> totalUserMoney(@Param("start") String start, @Param("end") String end);


}
