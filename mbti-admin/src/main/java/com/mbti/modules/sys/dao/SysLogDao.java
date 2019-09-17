/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
** @author *
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
