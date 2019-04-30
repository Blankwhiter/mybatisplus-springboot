package com.example.mybatisplus.entity;

import lombok.Data;

/**
 *  user 实体类
 */
@Data
public class User {
    private String id;
    private String name;
    private Integer age;
    private String email;
}
