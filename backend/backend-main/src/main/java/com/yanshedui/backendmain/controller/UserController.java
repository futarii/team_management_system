package com.yanshedui.backendmain.controller;

import com.yanshedui.backendcommon.entity.PlayerProfile;
import com.yanshedui.backendcommon.entity.User;
import com.yanshedui.backendcommon.entity.vo.UserInfoVO;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import com.yanshedui.backendsystem.service.UserService;
import com.yanshedui.backendteam.service.PlayerProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PlayerProfileService playerProfileService;

    @GetMapping("/getUserInfoById/{id}")
    public Result<UserInfoVO> getUserInfoById(@PathVariable Integer id) {
        // TODO 这里通过token判断用户Id
        User user = userService.getUserById(id);
        PlayerProfile player = playerProfileService.getPlayerByUserId(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        BeanUtils.copyProperties(player, userInfoVO);
        return Result.success(ResultCode.SelectSuccess, userInfoVO);
    }

}
