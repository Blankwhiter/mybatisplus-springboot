package com.example.mybatisplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.entity.User;

/**
 *  用户mapper
 */
@DS("slave") //这里是配置数据源注解，默认是master
public interface UserMapper extends BaseMapper<User> {
}
