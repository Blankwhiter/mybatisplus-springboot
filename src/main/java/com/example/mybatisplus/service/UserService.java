package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.User;

/**
 * userService 接口定义
 */
public interface UserService extends IService<User> {
    /**
     * 通过用户名 查找用户
     * @param name
     * @return
     */
    User findUserByName(String name);
}
