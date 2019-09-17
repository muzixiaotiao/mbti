package com.mbti.modules.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbti.modules.platform.dao.AnalysisDao;
import com.mbti.modules.platform.entity.AnalysisEntity;
import com.mbti.modules.platform.service.AnalysisService;
import org.springframework.stereotype.Service;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 09:48
 * @description: 测评用户字典
 **/
@Service
public class AnalysisServiceImpl extends ServiceImpl<AnalysisDao, AnalysisEntity> implements AnalysisService {

    @Override
    public AnalysisEntity queryByCode(String code){
        return baseMapper.queryByCode(code);
    }
}
