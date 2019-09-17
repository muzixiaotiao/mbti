package com.mbti.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 10:18
 * @description: 问题表
 **/
@Data
@TableName("mbti_question")
public class QuestionEntity extends BaseEntity {

    /**
     * 问题类型 1：MBTI  2：心理测试10题
     */
    private Integer infoId;
    /**
     * 问题名称
     */
    private String name;
    /**
     * 答案类型(S:单选 D:多选)
     */
    private String type;
}
