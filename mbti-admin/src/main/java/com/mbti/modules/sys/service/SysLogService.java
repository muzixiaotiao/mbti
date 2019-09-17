/**
 * MBTI性格测试系统.
**/

package com.mbti.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.common.utils.PageUtils;
import com.mbti.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
** @author *
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
