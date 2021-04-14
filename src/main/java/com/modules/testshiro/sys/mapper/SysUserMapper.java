package com.modules.testshiro.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.testshiro.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * InterfaceName  SysUserMapper
 * Description 用户mapper
 * Author F
 * Date  2021/4/14 9:57
 * Version    1.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
