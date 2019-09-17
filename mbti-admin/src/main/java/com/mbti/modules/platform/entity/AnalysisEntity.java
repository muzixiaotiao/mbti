package com.mbti.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:11
 * @description: 测评结果
 **/
@Data
@TableName("mbti_analysis")
public class AnalysisEntity extends BaseEntity {

    /**
     * 组合编码
     */
    private String code;

    /**
     * 性格详情
     */
    private String content;

}
