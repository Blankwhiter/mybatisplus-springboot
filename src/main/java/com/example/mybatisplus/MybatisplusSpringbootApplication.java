package com.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}) //去掉springboot 默认的数据源配置
@MapperScan("com.example.mybatisplus.mapper") //扫描mapper的包，或者读者可以在对应的mapper上加上@Mapper的注解
public class MybatisplusSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusSpringbootApplication.class, args);
    }

}
