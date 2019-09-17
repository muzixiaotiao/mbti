package com.mbti.modules.platform.vo;

import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 14:52
 * @description: 查看报告VO类
 **/
@Data
public class ReportVO {
    private String mobile;
    private String createTime;
    private String content;
    private Integer status;
}
