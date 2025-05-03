package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendannouncement.service.AnnouncementService;
import com.yanshedui.backendcommon.entity.Announcement;
import com.yanshedui.backendcommon.entity.dto.AnnouncementDTO;
import com.yanshedui.backendcommon.entity.vo.AnnouncementVO;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import com.yanshedui.backendcommon.utils.PageVOUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        PageVO<AnnouncementVO> pageVO = PageVOUtil.getPageVO(announcementPage);
        return Result.success(ResultCode.SelectSuccess, pageVO);
    }

    @PutMapping("/updateAnnouncementById/{id}")
    public Result<String> updateAnnouncementById(
            @PathVariable Integer id,
            @Valid @RequestBody Announcement announcement
            ) {
        announcement.setAnnounceId(id);
        AnnouncementDTO announcementDTO = new AnnouncementDTO();

        BeanUtils.copyProperties(announcement, announcementDTO);
        System.out.println(announcementDTO);
        Boolean isUpdated = announcementService.updateAnnouncementById(announcementDTO);

        if(!isUpdated) {
            return Result.error(ResultCode.UpdateError, ResultMessage.UpdateError);
        }
        return Result.success(ResultCode.UpdateSuccess, ResultMessage.UpdateSuccess);
    }

    @DeleteMapping("/deleteAnnouncementById/{id}")
    public Result<String> deleteAnnouncementById(@PathVariable Integer id) {
        boolean isDeleted = announcementService.removeById(id);
        if(!isDeleted) {
            return Result.error(ResultCode.DeleteError, ResultMessage.DeleteError);
        }
        return Result.success(ResultCode.DeleteSuccess, ResultMessage.DeleteSuccess);
    }

    @PostMapping("/createAnnouncement")
    public Result<String> createAnnouncement(@Valid @RequestBody Announcement announcement) {
        // TODO 此处应该根据当前token解析用户id并赋值
        boolean isSaved = announcementService.save(announcement);
        if(!isSaved) {
            return Result.error(ResultCode.InsertError, ResultMessage.InsertError);
        }
        return Result.success(ResultCode.InsertSuccess, ResultMessage.InsertSuccess);
    }


}
