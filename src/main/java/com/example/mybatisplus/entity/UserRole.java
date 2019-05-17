package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户角色关系实体类
 */
@Data
public class UserRole extends Model<UserRole> {
    String id;
    String roleId;
    String userId;
}
