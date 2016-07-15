package com.it.service;

import com.it.mapper.DocumentMapper;
import com.it.pojo.Document;
import com.it.util.ShiroUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.print.Doc;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Named
public class DocumentService {
    @Inject
    private DocumentMapper documentMapper;
    @Value("${imagePath}")
    private String savePath;

    public List<Document> findDocumentByFid(Integer fid) {
   return documentMapper.findByFid(fid);
    }

    /**
     * 新建文件夹
     * @param name
     * @param fid
     */
    public void saveDir(String name, Integer fid) {
       Document document =new Document();
        document.setName(name);
        document.setFid(fid);
        document.setCreateuser(ShiroUtil.getCurrentRealName());
        document.setType(Document.TYPE_DIR);
        documentMapper.save(document);
    }

    /**
     * 保存文件
     * @param inputStream 文件输入流
     * @param originalFilename 文件真实名称
     * @param contentType 文件MIME类型
     * @param size 文件大小（字节）
     * @param fid 父ID
     */
    @Transactional
    public void saveFile(InputStream inputStream, String originalFilename, String contentType, long size, Integer fid) {
        //String md5 =nul;
        String extName="";
        if(originalFilename.lastIndexOf(".") != -1){
            extName =originalFilename.substring(originalFilename.lastIndexOf("."));

        }
        String newFileName = UUID.randomUUID().toString() +extName;
        //md5 =DigestUtils.md5Hex(inputStream);
        try {
            FileOutputStream outputStream =new FileOutputStream(new File(savePath,newFileName));
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            throw  new RuntimeException(ex);
        }
        Document document =new Document();
        document.setName(originalFilename);
        document.setFid(fid);
        document.setType(Document.TYPE_DOC);
        document.setCreateuser(ShiroUtil.getCurrentRealName());
        document.setContexttype(contentType);
        document.setSize(FileUtils.byteCountToDisplaySize(size));
        document.setFilename(newFileName);
        documentMapper.save(document);


    }

    /**
     * 根据ID获取文件
     * @param id
     * @return
     */

    public Document findDocumentById(Integer id){
        return documentMapper.findById(id);

    }
}
