package com.modules.testshiro.sys.entity;

import lombok.Data;

/**
 * ClassName  SysUser
 * Description    用户
 * Author F
 * Date   2021/4/14 9:49
 * Version    1.0
 */
@Data
public class SysUser {
    private String id;
    private String userName;
    private String userLoginName;
    private String userPassword;
    private String permissions;
    private String roles;
}
