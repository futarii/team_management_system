package com.yanshedui.backendteam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.TeamPosition;

public interface TeamPositionService extends IService<TeamPosition> {

    public Page<TeamPosition> getTeamPositionByPages(int currentPage, int pageSize);

    public boolean createTeamPosition(TeamPosition teamPosition);

}
