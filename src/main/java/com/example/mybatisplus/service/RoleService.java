package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.Role;

import java.util.List;

/**
 * roleService
 */
public interface RoleService extends IService<Role> {

    /**
     * 通过角色id查找出对应所有的用户具备角色名称
     * @param ids
     * @return
     */
     List<String> findRoleNameByRoleIds(List<String> ids);
}
