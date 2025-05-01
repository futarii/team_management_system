package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.TeamPosition;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.entity.vo.TeamPositionVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendteam.service.TeamPositionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
            @Min(value = 1, message = "当前页码必须大于等于1")
            Integer currentPage,

            @PathVariable
            @Min(value = 1, message = "每页数量必须大于等于1")
            Integer pageSize
    ) {

        Page<TeamPosition> teamPositionByPages = teamPositionService.getTeamPositionByPages(currentPage, pageSize);

        List<TeamPositionVO> teamPositionVOList = teamPositionByPages.getRecords().stream().map(teamPosition -> {
            TeamPositionVO teamPositionVO = new TeamPositionVO();
            BeanUtils.copyProperties(teamPosition, teamPositionVO);
            return teamPositionVO;
        }).toList();

        PageVO<TeamPositionVO> pageVO = new PageVO<>();
        pageVO.setRecords(teamPositionVOList);
        pageVO.setCurrentPage(teamPositionByPages.getCurrent());
        pageVO.setPageSize(teamPositionByPages.getSize());
        pageVO.setTotal(teamPositionByPages.getTotal());

        return Result.success(ResultCode.SelectSuccess, pageVO);

    }

    @PostMapping("/createTeamPosition")
    public Result<String> createTeamPosition(@Valid @RequestBody TeamPosition teamPosition) {
        teamPositionService.createTeamPosition(teamPosition);
        return Result.success(ResultCode.InsertSuccess, "新增角色成功");
    }

}
