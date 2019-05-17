package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;


/**
 * userService实现类
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public User findUserByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name",name);
        return baseMapper.selectOne(userQueryWrapper);
    }
}
