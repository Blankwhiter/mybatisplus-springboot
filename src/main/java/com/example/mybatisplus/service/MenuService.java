package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.entity.Menu;

import java.util.List;

/**
 * menuService
 */
public interface MenuService extends IService<Menu> {
    /**
     * 通过菜单id列表获得权限列表
     * @param menuIds
     * @return
     */
    List<String> findPermsByMenuIds(List<String> menuIds);
}
