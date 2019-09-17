package com.mbti.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:15
 * @description: 用户表
 **/
@Data
@TableName("mbti_user")
public class UserEntity extends BaseEntity {

    /**
     * 测试类型
     */
    private Integer infoId;
    /**
     * 登录手机号
     */
    private String mobile;
    /**
     * 状态 0未测评 1已测评
     */
    private Integer status;
    /**
     * 测评结果ID
     */
    private Long analysisId;
    /**
     * 测评结果编码
     */
    private String analysisCode;
    /**
     * 测评结果详情
     */
    private String detail;
    /**
     * 测评报告保存路径
     */
    private String filePath;

}
