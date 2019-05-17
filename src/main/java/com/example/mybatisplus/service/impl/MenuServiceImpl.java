package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.Menu;
import com.example.mybatisplus.mapper.MenuMapper;
import com.example.mybatisplus.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<String> findPermsByMenuIds(List<String> menuIds) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.in("id",menuIds);
        return baseMapper.selectList(wrapper).stream().map(Menu::getPerms).collect(Collectors.toList());
    }
}
