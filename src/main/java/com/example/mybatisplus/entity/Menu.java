package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 菜单实体类
 */
@Data
public class Menu extends Model<Menu> {
    String id;
    String menuName;
    String perms;
    String url;
}
