package com.mbti.modules.platform.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 15:55
 * @description: 测评结果请求类
 **/
@Data
public class ReportRequest {
    private Integer infoId;
    private String mobile;
    private List<Long> anwserList;
}
