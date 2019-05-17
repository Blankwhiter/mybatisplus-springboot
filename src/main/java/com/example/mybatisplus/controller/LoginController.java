package com.example.mybatisplus.controller;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.exception.GenericExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 登录类
 */
@Slf4j
@RestController
public class LoginController  {

    @Value("${shiro.session.timeOut}")
    private Long sessionTimeOut;

    /**
     * 登陆验证
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String login(User user){
        //获得subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        //登录验证。没有异常则表示登录成功，发生异常表示登录失败
        try {
            subject.login(token);
            //session 设置超时时间
            subject.getSession().setTimeout(sessionTimeOut);
            log.info("sessionId : {}",subject.getSession().getId().toString());
            log.info("登录完成");
            return subject.getSession().getId().toString();
        }catch (UnknownAccountException e){
            log.info("用户名不存在");
            return "用户名不存在";
        }catch (IncorrectCredentialsException e){
            log.info("密码错误");
            return "密码错误";
        }finally {
            log.info("执行完毕");
        }

    }


    /**
     * 未登录， 会重定向到此处
     * @return
     */
    @RequestMapping(value = "/unAuthentication")
    @ResponseBody
    public Object unAuthentication() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "101");
        map.put("msg", "未登录");
        return map;
    }


    /**
     * 测试数据配置了给只有admin角色权限可以访问
     * @return
     */
    @GetMapping("/add")
    @RequiresPermissions("user:add")
    public String addUser(){
      log.info(" run add user");
      return "add user success";
    }


    /**
     * 具有admin normal角色都可以访问
     * @return
     */
    @GetMapping("/update")
    @RequiresPermissions("user:update")
    public String updateUser(){
      log.info(" run update user");
      return "update user success";
    }
}
