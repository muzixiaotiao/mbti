package com.mbti.modules.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.modules.platform.entity.AnalysisEntity;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 09:47
 * @description: 测评结果字典
 **/
public interface AnalysisService extends IService<AnalysisEntity> {

    AnalysisEntity queryByCode(String code);
}
