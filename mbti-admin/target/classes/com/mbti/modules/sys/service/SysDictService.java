/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.common.utils.PageUtils;
import com.mbti.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典
** @author *
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

