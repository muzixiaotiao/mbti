package com.mbti.modules.platform.vo;

import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 14:58
 * @description: 答案
 **/
@Data
public class AnwserDTO {
    /**
     * id
     */
    private Long id;
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
}
