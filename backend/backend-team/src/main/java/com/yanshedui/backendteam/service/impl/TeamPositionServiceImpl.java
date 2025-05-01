package com.yanshedui.backendteam.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanshedui.backendcommon.entity.TeamPosition;
import com.yanshedui.backendteam.dao.TeamPositionDao;
import com.yanshedui.backendteam.service.TeamPositionService;
import org.springframework.stereotype.Service;

@Service
public class TeamPositionServiceImpl extends ServiceImpl<TeamPositionDao, TeamPosition> implements TeamPositionService {

    @Override
    public Page<TeamPosition> getTeamPositionByPages(int currentPage, int pageSize) {
        Page<TeamPosition> page = new Page<>(currentPage, pageSize);
        return this.page(page);
    }

    @Override
    public boolean createTeamPosition(TeamPosition teamPosition) {
        return this.save(teamPosition);
    }
}
