package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.TeamPosition;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.entity.vo.TeamPositionVO;
import com.yanshedui.backendcommon.exception.BusinessException;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import com.yanshedui.backendcommon.utils.PageVOUtil;
import com.yanshedui.backendteam.service.TeamPositionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team/position")
@Validated
public class TeamPositionController {

    @Autowired
    private TeamPositionService teamPositionService;

    @GetMapping("/getTeamPositionByPages/{currentPage}/{pageSize}")
    public Result<PageVO<TeamPositionVO>> getTeamPositionByPages(
            @PathVariable
            @Min(value = 1, message = ResultMessage.CurrentPageValid)
            Integer currentPage,

            @PathVariable
            @Min(value = 1, message = ResultMessage.PageSizeValid)
            Integer pageSize
    ) {
        Page<TeamPosition> teamPositionByPages = teamPositionService.getTeamPositionByPages(currentPage, pageSize);
        PageVO<TeamPositionVO> pageVO = PageVOUtil.getPageVOByDataVO(teamPositionByPages, TeamPositionVO.class);
        return Result.success(ResultCode.SelectSuccess, pageVO);
    }

    @PostMapping("/createTeamPosition")
    public Result<String> createTeamPosition(@Valid @RequestBody TeamPosition teamPosition) {
        try {
            boolean isSaved = teamPositionService.createTeamPosition(teamPosition);
            if(!isSaved) {
                return Result.error(ResultCode.InsertError, ResultMessage.InsertError);
            }
            return Result.success(ResultCode.InsertSuccess, ResultMessage.InsertSuccess);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ResultCode.DataAlreadyExist, ResultMessage.DataAlreadyExist);
        }
    }

    @DeleteMapping("/deleteTeamPositionById/{id}")
    public Result<String> deleteTeamPositionById(@PathVariable Integer id) {
        boolean isDeleted = teamPositionService.removeById(id);
        if(!isDeleted) {
            return Result.error(ResultCode.DeleteError, ResultMessage.DeleteError);
        }
        return Result.success(ResultCode.DeleteSuccess, ResultMessage.DeleteSuccess);
    }

    @PutMapping("/updateTeamPosition/{id}")
    public Result<String> updateTeamPosition(
            @PathVariable Integer id,
            @Valid @RequestBody TeamPosition teamPosition
    ) {
        teamPosition.setPositionId(id);
        boolean isUpdated = teamPositionService.updateById(teamPosition);
        if (!isUpdated) {
            return Result.error(ResultCode.UpdateError, ResultMessage.UpdateError);
        }
        return Result.error(ResultCode.UpdateSuccess, ResultMessage.UpdateSuccess);
    }

}
