package com.mbti.modules.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.modules.platform.entity.QuestionEntity;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 14:22
 * @description: 测评问题
 **/
public interface QuestionService extends IService<QuestionEntity> {

    /**
     * 问题随机列表
     * @return
     */
    List<Long> queryQuestionIdByRandom(Integer infoId);

}
