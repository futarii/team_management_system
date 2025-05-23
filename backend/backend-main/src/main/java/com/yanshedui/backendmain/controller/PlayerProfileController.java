package com.yanshedui.backendmain.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.PlayerProfile;
import com.yanshedui.backendcommon.entity.dto.PlayerProfileDTO;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import com.yanshedui.backendcommon.entity.vo.PlayerProfileVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import com.yanshedui.backendcommon.utils.PageVOUtil;
import com.yanshedui.backendteam.service.PlayerProfileService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@Validated
public class PlayerProfileController {

    @Autowired
    private PlayerProfileService playerProfileService;

    @GetMapping("/getPlayersByPage/{currentPage}/{pageSize}")
    public Result<PageVO<PlayerProfileVO>> getPlayersByPage(
            @PathVariable
            @Min(value = 1, message = ResultMessage.CurrentPageValid)
            Integer currentPage,

            @PathVariable
            @Min(value = 1, message = ResultMessage.PageSizeValid)
            Integer pageSize
    ) {
        Page<PlayerProfile> playersByPage = playerProfileService.getPlayersByPage(currentPage, pageSize);
        PageVO<PlayerProfileVO> pageVO = PageVOUtil.getPageVOByDataVO(playersByPage, PlayerProfileVO.class);
        return Result.success(ResultCode.SelectSuccess, pageVO);
    }

    @PutMapping("/updatePlayerProfile/{id}")
    public Result<String> updatePlayerProfile(
            @PathVariable Integer id,
            @Valid @RequestBody PlayerProfile playerProfile
    ) {

        playerProfile.setProfileId(id);
        PlayerProfileDTO playerProfileDTO = new PlayerProfileDTO();
        BeanUtils.copyProperties(playerProfile, playerProfileDTO);

        Boolean isUpdated = playerProfileService.updatePlayerProfileById(playerProfileDTO);

        if(!isUpdated) {
            return Result.error(ResultCode.UpdateError, ResultMessage.UpdateError);
        }
        return Result.success(ResultCode.UpdateSuccess, ResultMessage.UpdateSuccess);
    }

}
