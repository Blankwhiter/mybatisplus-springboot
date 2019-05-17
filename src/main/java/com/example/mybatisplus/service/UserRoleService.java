package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.UserRole;

import java.util.List;

/**
 *  userRoleService
 */
public interface UserRoleService   extends IService<UserRole> {
    /**
     * 通过用户id 查找出具备的角色id
     * @param userId
     * @return
     */
    List<String> findRoleIdsByUserId(String userId);
}
