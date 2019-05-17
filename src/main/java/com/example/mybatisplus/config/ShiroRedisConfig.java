package com.example.mybatisplus.config;

import lombok.Data;
import org.crazycake.shiro.RedisManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

/**
 * 配置redis环境 供shiro-redis插件使用
 */
@Data
@Component
@ConfigurationProperties(prefix = "shiro.redis")
public class ShiroRedisConfig {

    private String host;

    private int database;

    private String password;

    private int timeOut;

    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setDatabase(database);
        redisManager.setHost(host);
        redisManager.setPassword(password);
        redisManager.setTimeout(timeOut);
        return redisManager;
    }
}
