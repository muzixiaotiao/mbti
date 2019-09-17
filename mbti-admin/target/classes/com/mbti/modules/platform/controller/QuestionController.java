package com.mbti.modules.platform.controller;

import com.mbti.common.utils.RespResult;
import com.mbti.modules.platform.entity.AnwserEntity;
import com.mbti.modules.platform.entity.QuestionEntity;
import com.mbti.modules.platform.entity.UserEntity;
import com.mbti.modules.platform.service.AnwserService;
import com.mbti.modules.platform.service.QuestionService;
import com.mbti.modules.platform.vo.AnwserDTO;
import com.mbti.modules.platform.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 14:43
 * @description: 测评问题
 **/
@Controller
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnwserService anwserService;

    /**
     * 查询问题列表，顺序随机
     * @return
     */
    @RequestMapping("/list/{infoId}")
    @ResponseBody
    public RespResult queryQuestionIdByRandom(@PathVariable("infoId") Integer infoId){
        List questionList = questionService.queryQuestionIdByRandom(infoId);
        RespResult result = new RespResult(RespResult.SUCCESS, questionList);
        return result;
    }

    /**
     * 查询问题答案详情
     * @param questionId
     * @return
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public RespResult queryQuestionAnwserByQuestionId(@PathVariable("id") Long questionId){
        QuestionEntity question = questionService.getById(questionId);
        List<AnwserDTO> anwserList = anwserService.queryAnwsersByQuestionId(questionId);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setQuestionName(question.getName());
        questionVO.setQuestionId(questionId);
        questionVO.setAnwserList(anwserList);
        RespResult result = new RespResult(RespResult.SUCCESS, questionVO);
        return result;
    }
}
