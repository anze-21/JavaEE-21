package com.it.service;

import com.it.mapper.NoticeMapper;
import com.it.pojo.Notice;
import com.it.util.ShiroUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Named
public class NoticeService {
    @Inject
    private NoticeMapper noticeMapper;
    @Value("${imagePath}")
    private String imageSavePath;

    /**
     * 保存新的公告
     * @param notice
     */
    public void saveNotice(Notice notice) {
        notice.setUserid(ShiroUtil.getCurrentUserID());
        notice.setRealname(ShiroUtil.getCurrentRealName());
        noticeMapper.save(notice);
    }
    //TODO微信通知

    /**
     * 根据条件查询NOtice集合
     * @param param
     * @return
     */
    public List<Notice> findByParam(Map<String,Object> param){
        return noticeMapper.findByParam(param);

    }

    /**
     * 获取公告的总数量
     * @return
     */
    public Long count(){
        return noticeMapper.count();

    }

    /**
     * 根据主键查找对象
     * @param id
     * @return
     */
    public Notice findNoticeById(Integer id ){
        return noticeMapper.findById(id);

    }

    /**
     * 将在线编辑的上传文件进行保存
     * @param inputStream
     * @param fileName
     * @return
     */
    public String saveImage(InputStream inputStream,String fileName) throws IOException {
        String extName =fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString();// +extName

        FileOutputStream outputStream =new FileOutputStream(new File(imageSavePath,newFileName));
        IOUtils.copy(inputStream,outputStream);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
        return "/preview/"+newFileName;

    }



}
