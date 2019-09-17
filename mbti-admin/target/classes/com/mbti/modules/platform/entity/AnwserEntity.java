package com.mbti.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 10:28
 * @description: 答案
 **/
@Data
@TableName("mbti_answer")
public class AnwserEntity extends BaseEntity {

    /**
     * 问题答案编码A B
     */
    private String code;
    /**
     * 答案详情
     */
    private String name;
    /**
     * 问题ID
     */
    private Long questionId;
    /**
     * 对应性格类型 E、I、S、N、T、F、J、P
     */
    private String characterType;

}
