package com.yanshedui.backendteam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.TeamPosition;

public interface TeamPositionService extends IService<TeamPosition> {

    Page<TeamPosition> getTeamPositionByPages(int currentPage, int pageSize);

    boolean createTeamPosition(TeamPosition teamPosition);

}
