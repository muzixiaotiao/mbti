package com.mbti.modules.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbti.modules.platform.dao.AnwserDao;
import com.mbti.modules.platform.entity.AnwserEntity;
import com.mbti.modules.platform.service.AnwserService;
import com.mbti.modules.platform.vo.AnwserDTO;
import com.mbti.modules.platform.vo.ReportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 15:05
 * @description: 测评答案实现
 **/
@Service
public class AnwserServiceImpl extends ServiceImpl<AnwserDao, AnwserEntity> implements AnwserService {

    @Override
    public List<AnwserDTO> queryAnwsersByQuestionId(Long questionId){
        return baseMapper.queryAnwsersByQuestionId(questionId);
    }
    @Override
    public List<ReportDTO> countCharacterScore(List<Long> anwserList){
        return baseMapper.countCharacterScore(anwserList);
    }

}
