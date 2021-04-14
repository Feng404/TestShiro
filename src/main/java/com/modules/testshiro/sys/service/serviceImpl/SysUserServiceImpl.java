package com.modules.testshiro.sys.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.testshiro.sys.entity.SysUser;
import com.modules.testshiro.sys.mapper.SysUserMapper;
import com.modules.testshiro.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * ClassName  SysUserServiceImpl
 * Description    用户serviceImpl
 * Author F
 * Date   2021/4/14 10:17
 * Version    1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public SysUser getByUserLoginName(String userLoginName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_login_name", userLoginName);
        return baseMapper.selectOne(queryWrapper);
    }
}
