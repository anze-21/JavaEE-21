package com.it.mapper;

import com.it.pojo.Document;

import javax.print.Doc;
import java.util.List;

public interface DocumentMapper {
    void save(Document document);
    List<Document> findByFid(Integer id);
    Document findById(Integer id);
    void del(Integer id);
}
