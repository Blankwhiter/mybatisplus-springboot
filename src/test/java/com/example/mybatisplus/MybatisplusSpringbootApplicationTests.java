package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 简单的测试增删改查
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusSpringbootApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
        User user = new User();
        user.setAge(200);
        user.setEmail("belonghuang@outlook.com");
        user.setName("belongHuang");
        userMapper.insert(user);
    }

    @Test
    public void updateUser() {
        User user = userMapper.selectById(1);
        user.setAge(300);
        int i = userMapper.updateById(user);
        if (i>0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void deleteUser() {
        int i = userMapper.deleteById(1);
        if (i>0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
    @Test
    public void selectUser() {
        List<User> users = userMapper.selectList(null);
        users.stream().map(User::getName).forEach(System.out::println);//打印出所用用户名字
    }

}
