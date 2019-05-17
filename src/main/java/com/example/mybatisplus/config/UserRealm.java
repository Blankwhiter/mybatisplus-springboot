package com.example.mybatisplus.config;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

/**
 * 用户权限realm ，认证授权最终都在此处实现，用于安全框架dao
 */
@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private MenuService menuService;
    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("UserRealm.doGetAuthenticationInfo  认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        log.info("username : {}", username);
        char[] password = token.getPassword();
        log.info("password : {}", password);

        //1.判断用户名是否存在
        User user = userService.findUserByName(username);
        if(user == null){
            //返回null 会抛出 UnknownAccountException
            return null;
        }else {
            //2.判断密码是否正确,密码则不需要自己判断 ，通过SimpleAuthenticationInfo，第二参数判断是否一致即可，第一个参数是为了在赋予权限时候拿到对应的用户
            return new SimpleAuthenticationInfo(user,user.getPassword(),"");
        }

    }

    /**
     * 执行赋予授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("UserRealm.doGetAuthorizationInfo  授权");
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //从认证中获得用户  return new SimpleAuthenticationInfo(user,user.getPassword(),"");
        User user = (User)principals.getPrimaryPrincipal();
        String userId = user.getId();
        //1.通过用户id查找出用户角色
        List<String> roleIdsList = userRoleService.findRoleIdsByUserId(userId);
        List<String> roleNamesList = roleService.findRoleNameByRoleIds(roleIdsList);
        HashSet<String> roleSet = new HashSet<>(roleNamesList);
        info.setRoles(roleSet);
        //2.通过角色找到对应的权限

        HashSet<String> roleIdsSet = new HashSet<>(roleIdsList);
        List<String> menuIds = roleMenuService.findMenuIdsByRoleIds(roleIdsSet);
        List<String> perms = menuService.findPermsByMenuIds(menuIds);
        info.addStringPermissions(perms);
        return info;
    }
}
