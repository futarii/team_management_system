package com.yanshedui.backendteam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.PlayerProfile;

public interface PlayerProfileService extends IService<PlayerProfile> {

    Page<PlayerProfile> getPlayersByPage(int currentPage, int pageSize);

}
