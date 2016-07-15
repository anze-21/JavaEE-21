package com.it.mapper;

import com.it.pojo.Notice;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface NoticeMapper {
    void save(Notice notice);
    List<Notice> findByParam(Map<String,Object> param);
    Long count();
    Notice findById(Integer id);
}
