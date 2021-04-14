package com.modules.testshiro.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.testshiro.sys.entity.SysUser;

/**
 * InterfaceName  SysUserService
 * Description 用户service
 * Author F
 * Date  2021/4/14 10:16
 * Version    1.0
 */
public interface SysUserService extends IService<SysUser> {
    SysUser getByUserLoginName(String loginName);
}
