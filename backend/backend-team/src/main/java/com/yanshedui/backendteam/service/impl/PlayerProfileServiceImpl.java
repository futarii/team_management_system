package com.yanshedui.backendteam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanshedui.backendcommon.entity.PlayerProfile;
import com.yanshedui.backendcommon.entity.dto.PlayerProfileDTO;
import com.yanshedui.backendteam.dao.PlayerProfileDao;
import com.yanshedui.backendteam.service.PlayerProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileServiceImpl extends ServiceImpl<PlayerProfileDao, PlayerProfile> implements PlayerProfileService {

    @Override
    public Page<PlayerProfile> getPlayersByPage(Integer currentPage, Integer pageSize) {
        Page<PlayerProfile> page = new Page<>(currentPage, pageSize);
        return this.page(page);
    }

    @Override
    public Boolean updatePlayerProfileById(PlayerProfileDTO playerProfileDTO) {
        PlayerProfile playerProfile = new PlayerProfile();
        BeanUtils.copyProperties(playerProfileDTO, playerProfile);
        return this.updateById(playerProfile);
    }

    @Override
    public PlayerProfile getPlayerByUserId(Integer id) {
        LambdaQueryWrapper<PlayerProfile> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerProfile::getUserId, id);
        queryWrapper.select(PlayerProfile::getRealName,
                PlayerProfile::getRealName,
                PlayerProfile::getJerseyNumber,
                PlayerProfile::getPosition,
                PlayerProfile::getHeight,
                PlayerProfile::getWeight,
                PlayerProfile::getJoinDate);
        return this.getOne(queryWrapper);
    }
}
