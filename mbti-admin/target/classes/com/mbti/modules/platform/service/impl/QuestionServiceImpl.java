package com.mbti.modules.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbti.modules.platform.dao.QuestionDao;
import com.mbti.modules.platform.entity.QuestionEntity;
import com.mbti.modules.platform.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 14:41
 * @description: 测评问题
 **/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, QuestionEntity> implements QuestionService {

    @Override
    public List<Long> queryQuestionIdByRandom(Integer infoId){
        return baseMapper.queryQuestionIdByRandom(infoId);
    }

}
