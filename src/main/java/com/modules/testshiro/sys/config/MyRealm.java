package com.modules.testshiro.sys.config;

import com.modules.testshiro.sys.entity.SysUser;
import com.modules.testshiro.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName  MyRealm
 * Description    shiro验证
 * Author F
 * Date   2021/4/14 10:24
 * Version    1.0
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    /**
     * @description  授权
     * @date 2021-04-14
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        //设置角色
        Set<String> roles = new HashSet<>();
        roles.add(sysUser.getRoles());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.addStringPermission(sysUser.getPermissions());
        return info;
    }

    /**
     * @description  认证
     * @date 2021-04-14
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        SysUser sysUser = sysUserService.getByUserLoginName(token.getUsername());
        if(sysUser != null){
            return new SimpleAuthenticationInfo(sysUser, sysUser.getUserPassword(), getName());
        }
        return null;
    }
}
