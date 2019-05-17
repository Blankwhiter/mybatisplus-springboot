package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.RoleMenu;
import com.example.mybatisplus.mapper.RoleMenuMapper;
import com.example.mybatisplus.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public List<String> findMenuIdsByRoleIds(Set<String> roleIds) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.in("role_id",roleIds);
        List<RoleMenu> roleMenuList = baseMapper.selectList(wrapper);
        return roleMenuList.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
    }
}
