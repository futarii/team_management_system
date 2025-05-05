package com.yanshedui.backendsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanshedui.backendcommon.entity.User;
import com.yanshedui.backendsystem.dao.UserDao;
import com.yanshedui.backendsystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User getUserById(Integer id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getUsername);
        return this.getById(id);
    }

}
