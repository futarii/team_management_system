package com.yanshedui.backendannouncement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.Announcement;
import com.yanshedui.backendcommon.entity.vo.AnnouncementVO;

public interface AnnouncementDao extends BaseMapper<Announcement> {

    Page<AnnouncementVO> selectAnnouncementWithUserPage(Page<AnnouncementVO> page);

}
