package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 角色菜单关系实体
 */
@Data
public class RoleMenu extends Model<RoleMenu> {
    String id;
    String roleId;
    String menuId;
}
