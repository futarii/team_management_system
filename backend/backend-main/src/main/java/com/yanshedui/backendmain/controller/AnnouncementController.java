package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendannouncement.service.AnnouncementService;
import com.yanshedui.backendcommon.entity.vo.AnnouncementVO;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/announcement")
@Validated
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/getAnnouncementsByPages/{currentPage}/{pageSize}")
    public Result<PageVO<AnnouncementVO>> getAnnouncementsByPages(
            @PathVariable
            @Min(value = 1, message = ResultMessage.CurrentPageValid)
            Integer currentPage,

            @PathVariable
            @Min(value = 1, message = ResultMessage.PageSizeValid)
            Integer pageSize
    ) {
        Page<AnnouncementVO> announcementPage = announcementService.getAnnouncementsByPages(currentPage, pageSize);

        PageVO<AnnouncementVO> pageVO = new PageVO<>();
        pageVO.setRecords(announcementPage.getRecords());
        pageVO.setCurrentPage(announcementPage.getCurrent());
        pageVO.setPageSize(announcementPage.getSize());
        pageVO.setTotal(announcementPage.getTotal());

        return Result.success(ResultCode.SelectSuccess, pageVO);
    }


}
