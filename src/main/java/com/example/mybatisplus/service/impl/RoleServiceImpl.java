package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.Role;
import com.example.mybatisplus.mapper.RoleMapper;
import com.example.mybatisplus.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<String> findRoleNameByRoleIds(List<String> ids) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.in("id",ids);
        List<Role> roleList = baseMapper.selectList(wrapper);
        return roleList.stream().map(Role::getRole_name).collect(Collectors.toList());
    }
}
