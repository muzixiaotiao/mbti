package com.mbti.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.platform.entity.AnalysisEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:37
 * @description: 测评报告
 **/
@Mapper
public interface AnalysisDao extends BaseMapper<AnalysisEntity> {

    AnalysisEntity queryByCode(String code);

}
