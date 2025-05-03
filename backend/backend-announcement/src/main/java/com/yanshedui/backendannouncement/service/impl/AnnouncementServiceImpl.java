package com.yanshedui.backendannouncement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanshedui.backendannouncement.dao.AnnouncementDao;
import com.yanshedui.backendannouncement.service.AnnouncementService;
import com.yanshedui.backendcommon.entity.Announcement;
import com.yanshedui.backendcommon.entity.dto.AnnouncementDTO;
import com.yanshedui.backendcommon.entity.vo.AnnouncementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, Announcement> implements AnnouncementService {

    @Override
    public Page<AnnouncementVO> getAnnouncementsByPages(int currentPage, int pageSize) {
        Page<AnnouncementVO> page = new Page<>(currentPage, pageSize);
        return baseMapper.selectAnnouncementWithUserPage(page);
    }

    @Override
    public Boolean updateAnnouncementById(AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(announcementDTO, announcement);
        announcement.setUpdateTime(LocalDateTime.now());
        System.out.println(announcement);

        return this.updateById(announcement);
    }

}
