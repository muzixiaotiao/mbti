/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.common.utils.PageUtils;
import com.mbti.modules.sys.entity.SysRoleEntity;

import java.util.Map;


/**
 * 角色
** @author *
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);
	
	void deleteBatch(Long[] roleIds);

}
