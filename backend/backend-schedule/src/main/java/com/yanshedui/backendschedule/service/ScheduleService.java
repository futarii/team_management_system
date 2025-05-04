package com.yanshedui.backendschedule.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.Schedule;
import com.yanshedui.backendcommon.entity.dto.ScheduleDTO;

public interface ScheduleService extends IService<Schedule> {

    Page<Schedule> getSchedulesByPages(Integer currentPage, Integer pageSize);

    Boolean createSchedule(ScheduleDTO scheduleDTO);

}
