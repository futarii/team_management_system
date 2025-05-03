package com.yanshedui.backendschedule.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanshedui.backendcommon.entity.Schedule;
import com.yanshedui.backendschedule.dao.ScheduleDao;
import com.yanshedui.backendschedule.service.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleDao, Schedule> implements ScheduleService {

    @Override
    public Page<Schedule> getSchedulesByPages(Integer currentPage, Integer pageSize) {
        Page<Schedule> schedulePage = new Page<>(currentPage, pageSize);
        return this.page(schedulePage);
    }

}
