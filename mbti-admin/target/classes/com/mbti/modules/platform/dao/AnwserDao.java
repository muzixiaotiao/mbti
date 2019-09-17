package com.mbti.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.platform.entity.AnwserEntity;
import com.mbti.modules.platform.vo.AnwserDTO;
import com.mbti.modules.platform.vo.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:35
 * @description: 测评答案
 **/
@Mapper
public interface AnwserDao extends BaseMapper<AnwserEntity> {

    List<AnwserDTO> queryAnwsersByQuestionId(Long questionId);

    List<ReportDTO> countCharacterScore(List<Long> anwserList);
}
