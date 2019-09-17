package com.mbti.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.platform.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:34
 * @description: 测评问题
 **/
@Mapper
public interface QuestionDao extends BaseMapper<QuestionEntity> {

    List<Long> queryQuestionIdByRandom(Integer infoId);

}
