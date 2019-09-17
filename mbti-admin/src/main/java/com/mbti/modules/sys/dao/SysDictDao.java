/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
** @author *
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
