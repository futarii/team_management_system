package com.yanshedui.backendteam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanshedui.backendcommon.entity.PlayerProfile;
import com.yanshedui.backendcommon.entity.dto.PlayerProfileDTO;

public interface PlayerProfileService extends IService<PlayerProfile> {

    Page<PlayerProfile> getPlayersByPage(Integer currentPage, Integer pageSize);

    Boolean updatePlayerProfileById(PlayerProfileDTO playerProfileDTO);

    PlayerProfile getPlayerByUserId(Integer id);

}
