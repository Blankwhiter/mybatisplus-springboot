package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 *  user 实体类,并序列化
 */
@Data
public class User  extends Model<User> {
    private String id;
    private String name;
    private String password;
    private Integer age;
    private String email;
}
