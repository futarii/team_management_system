package com.yanshedui.backendannouncement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.Announcement;
import com.yanshedui.backendcommon.entity.vo.AnnouncementVO;

public interface AnnouncementService extends IService<Announcement> {

    Page<AnnouncementVO> getAnnouncementsByPages(int currentPage, int pageSize);

}
