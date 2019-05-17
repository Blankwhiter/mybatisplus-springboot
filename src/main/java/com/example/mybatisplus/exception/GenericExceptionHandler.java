package com.example.mybatisplus.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 *  全局异常捕捉
 *  controller层 要使用@RestController与RestControllerAdvice对应，如果使用@Controller 则使用@ControllerAdvice与之对应
 */
@RestControllerAdvice
public class GenericExceptionHandler {

    /**
     *  拦截没有权限的异常
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Map<String, Object> handleUnAuthorizedException(UnauthorizedException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "102");
        map.put("msg", "未授权");
        return map;
    }

    /**
     * 拦截异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "100");
        map.put("msg", e.getMessage());
        return map;
    }
}
