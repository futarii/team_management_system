package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.Schedule;
import com.yanshedui.backendcommon.entity.dto.ScheduleDTO;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.entity.vo.PlayerProfileVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import com.yanshedui.backendcommon.utils.PageVOUtil;
import com.yanshedui.backendschedule.service.ScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@Validated
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/getSchedulesByPages/{currentPage}/{pageSize}")
    public Result<PageVO<Schedule>> getSchedulesByPages(
            @PathVariable
            @Min(value = 1, message = ResultMessage.CurrentPageValid)
            Integer currentPage,

            @PathVariable
            @Min(value = 1, message = ResultMessage.PageSizeValid)
            Integer pageSize
    ) {
        Page<Schedule> schedulesByPages = scheduleService.getSchedulesByPages(currentPage, pageSize);
        PageVO<Schedule> pageVO = PageVOUtil.getPageVO(schedulesByPages);
        return Result.success(ResultCode.SelectSuccess, pageVO);
    }

    @PostMapping("/createSchedule")
    public Result<String> createSchedule(@RequestBody Schedule schedule) {

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        scheduleDTO.setScheduleId(null);

        Boolean isSaved = scheduleService.createSchedule(scheduleDTO);

        if(!isSaved) {
            return Result.error(ResultCode.InsertError, ResultMessage.InsertError);
        }
        return Result.success(ResultCode.InsertSuccess, ResultMessage.InsertSuccess);

    }



}
