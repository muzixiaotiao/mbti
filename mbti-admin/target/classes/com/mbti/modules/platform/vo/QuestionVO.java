package com.mbti.modules.platform.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 14:27
 * @description: 问题及答案
 **/
@Data
public class QuestionVO {

    Long questionId;
    String questionName;
    List<AnwserDTO> anwserList;

}
