package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.RoleMenu;

import java.util.List;
import java.util.Set;

/**
 * roleMenuService
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 通过角色id列表查找出所有对应的菜单id
     * @param roleIds
     * @return
     */
    List<String> findMenuIdsByRoleIds(Set<String> roleIds);
}
