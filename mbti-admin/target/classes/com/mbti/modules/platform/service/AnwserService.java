package com.mbti.modules.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.modules.platform.entity.AnwserEntity;
import com.mbti.modules.platform.vo.AnwserDTO;
import com.mbti.modules.platform.vo.ReportDTO;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 15:03
 * @description: 答案
 **/
public interface AnwserService extends IService<AnwserEntity> {

    List<AnwserDTO> queryAnwsersByQuestionId(Long questionId);

    List<ReportDTO> countCharacterScore(List<Long> questionId);
}
