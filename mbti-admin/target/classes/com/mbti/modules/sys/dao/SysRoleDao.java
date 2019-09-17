/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
** @author *
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	

}
