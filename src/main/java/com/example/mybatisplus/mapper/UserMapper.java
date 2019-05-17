package com.example.mybatisplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.entity.User;

/**
 *  用户mapper 这里 @DS 是配置数据源注解，默认是master
 */
@DS("slave")
public interface UserMapper extends BaseMapper<User> {
}
