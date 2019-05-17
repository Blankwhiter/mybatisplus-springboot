package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 角色实体类
 */
@Data
public class Role extends Model<Role> {
    String id;
    String role_name;
    String role_desc;
}
