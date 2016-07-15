package com.it.service;

import com.it.mapper.NoticeMapper;
import com.it.pojo.Notice;
import com.it.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class NoticeService {
    @Inject
    private NoticeMapper noticeMapper;

    /**
     * 保存新的公告
     * @param notice
     */
    public void saveNotice(Notice notice) {
        notice.setUserid(ShiroUtil.getCurrentUserID());
        notice.setRealname(ShiroUtil.getCurrentRealName());
        noticeMapper.save(notice);
    }
}
