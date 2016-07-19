package com.it.mapper;

import com.it.pojo.SalesFile;

import java.util.List;

/**
 * Created by zml on 2016/7/18.
 */
public interface SalesFileMapper {
    List<SalesFile> findBySalesId(Integer salesId);

    void save(SalesFile salesFile);
    SalesFile findById(Integer id);
}
